package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.model.dto.response.ExceptionResponse;
import com.example.demo.model.exception.ValidationException;

@ControllerAdvice
public class Controller {

	@Autowired
	HttpServletResponse response ; 
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ValidationException.class})
	public ExceptionResponse responseValidationException(ValidationException exception) {
		return ExceptionResponse.builder().message(exception.getMessage()).build();
	}
	
}
