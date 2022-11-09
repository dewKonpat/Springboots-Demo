package com.example.demo.model.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestModel {

	@NotEmpty
	private String firstName;
	
	@NotNull
	private String lastName;
	
}
