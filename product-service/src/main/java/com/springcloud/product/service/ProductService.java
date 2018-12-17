package com.springcloud.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.springcloud.product.model.Product;

/**
 *
 * @author afiore
 * Created on 2018-12-17
 */

@Service
public class ProductService {

	private List<Product> products;
	
	@PostConstruct
	private void init() {
		products = new ArrayList<>();
		products.add(new Product(1, "Product 1", 2.5));
		products.add(new Product(2, "Product 2", 1.99));
	}
	
	public Optional<Product> findById(Integer id) {
		return products.stream().filter(p -> p.getId().equals(id)).findFirst();
	}
}
