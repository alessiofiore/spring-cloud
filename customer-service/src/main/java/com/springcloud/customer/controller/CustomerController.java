package com.springcloud.customer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.customer.exception.ResourceNotFoundException;
import com.springcloud.customer.model.Customer;
import com.springcloud.customer.service.CustomerService;

/**
 *
 * @author afiore
 * Created on 2018-12-17
 */

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService productService;

	@GetMapping("/{id}")
	public Customer findById(@PathVariable Integer id) {
		Optional<Customer> prod = productService.findById(id);
		if(prod.isPresent()) {
			return prod.get();
		} else {
			throw new ResourceNotFoundException("Product not found");
		}
	}	
}
