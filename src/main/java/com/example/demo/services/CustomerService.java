package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.request.CustomerRequestModel;
import com.example.demo.model.dto.response.CustomerResponseModel;
import com.example.demo.model.exception.ValidationException;

@Service
public class CustomerService {

	public CustomerResponseModel addOrder(CustomerRequestModel userModel) {
	
		return CustomerResponseModel.builder()
								.firstName("Hello")
								.lastname("World")
								.age("20").build();
		
	}

	public void validateUser(CustomerRequestModel userModel) throws ValidationException {
		
		if( !"Hello".equals(userModel.getFirstName())) {
			throw new ValidationException("user name not valid.");
		}
		
	}
	
}
