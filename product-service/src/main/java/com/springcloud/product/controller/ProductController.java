package com.springcloud.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.product.exception.ResourceNotFoundException;
import com.springcloud.product.model.Product;
import com.springcloud.product.service.ProductService;

/**
 *
 * @author afiore
 * Created on 2018-12-17
 */

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/{id}")
	public Product findById(@PathVariable Integer id) {
		Optional<Product> prod = productService.findById(id);
		if(prod.isPresent()) {
			return prod.get();
		} else {
			throw new ResourceNotFoundException("Product not found");
		}
	}	
}
