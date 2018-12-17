package com.springcloud.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.springcloud.customer.model.Customer;

/**
 *
 * @author afiore
 * Created on 2018-12-17
 */

@Service
public class CustomerService {

	private List<Customer> products;
	
	@PostConstruct
	private void init() {
		products = new ArrayList<>();
		products.add(new Customer(1, "Customer 1"));
		products.add(new Customer(2, "Customer 2"));
	}
	
	public Optional<Customer> findById(Integer id) {
		return products.stream().filter(p -> p.getId().equals(id)).findFirst();
	}
}
