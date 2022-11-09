package com.example.demo.model.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetailsModel {
	
	private String field;
	
	private String message;
	
	private String name;

	public ErrorDetailsModel() {
		
	}

	public ErrorDetailsModel(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public ErrorDetailsModel(String name, String message, String field) {
		this.name = name;
		this.message = message;
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
