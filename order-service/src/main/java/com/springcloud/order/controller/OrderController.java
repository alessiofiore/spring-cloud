package com.springcloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.order.model.Order;
import com.springcloud.order.service.OrderService;

/**
 *
 * @author afiore
 * Created on 2018-12-17
 */

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping
	public Order prepare(@RequestBody Order order) {		
		return orderService.prepare(order);
	}	
}
