package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.model.dto.response.ExceptionResponse;
import com.example.demo.model.exception.ErrorDetailsModel;
import com.example.demo.model.exception.ValidationException;
import com.example.demo.utils.GsonUtil;

@ControllerAdvice
public class Controller {

	@Autowired
	HttpServletResponse response ; 
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ValidationException.class})
	public ExceptionResponse responseValidationException(ValidationException exception) {
		return ExceptionResponse.builder().message(exception.getMessage()).build();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public Object validationException(MethodArgumentNotValidException exception) {

		Map<String, FieldError> errors = new HashMap<>();
		for (ObjectError error : exception.getBindingResult().getAllErrors()) {
			FieldError field = GsonUtil.fromJson(GsonUtil.toJson(error), FieldError.class);
			if (Objects.nonNull(field.getField())) {
				if (errors.containsKey(field.getField())) {
					String code = field.getCodes()[field.getCodes().length - 1];
					if (code.equals("NotEmpty") || code.equals("NotNull") || code.equals("NotBlank")) {
						errors.put(field.getField(), field);
					}
				} else {
					errors.put(field.getField(), field);
				}
			} else {
				errors.put(error.getObjectName(),
						new FieldError(error.getObjectName(), error.getObjectName(), error.getDefaultMessage()));
			}
		}

		List<Object> errorList = new ArrayList<>();
		for (FieldError field : errors.values()) {
			errorList.add(new ErrorDetailsModel(field.getField(), field.getDefaultMessage()));
		}

		return errorList;

	}
	
}
