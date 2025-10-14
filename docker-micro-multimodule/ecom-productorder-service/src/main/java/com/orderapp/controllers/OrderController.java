package com.orderapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orderapp.service.IOrderService;

@RestController
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@PostMapping("/place-order")
public String placeOrder(@RequestParam int userId) {
	return orderService.placeOrder(userId);
}
}
