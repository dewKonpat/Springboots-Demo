package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.response.OrderResponseModel;
import com.example.demo.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOrderById( @PathVariable String id) {
	
		OrderResponseModel responseModel =  orderService.getOrderById(id);
		
		return ResponseEntity.ok(responseModel);
	}
	
	@GetMapping("/mobileNo/{mobileNo}")
	public ResponseEntity<Object> getOrderByMobileNo( @PathVariable String mobileNo ) {
	
		List<OrderResponseModel> responseModel =  orderService.getOrderByMobileNo(mobileNo);
		
		return ResponseEntity.ok(responseModel);
	}
	
	
}
