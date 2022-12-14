package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.request.CustomerRequestModel;
import com.example.demo.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController extends Controller {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Object> addOrder(@Validated @RequestBody CustomerRequestModel userModel) {
		
		customerService.addOrder(userModel);
		
		return ResponseEntity.ok("success");
	}
	
	@PostMapping("/exception")
	public  ResponseEntity<Object> getException(@RequestBody CustomerRequestModel userModel) throws Exception {
		
		customerService.validateUser(userModel);
		
		return ResponseEntity.ok("success");
	}
	
}
