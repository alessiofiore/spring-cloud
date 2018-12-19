package com.springcloud.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.order.client.ProductClient;
import com.springcloud.order.model.Order;
import com.springcloud.product.model.Product;

/**
 *
 * @author afiore
 * Created on 2018-12-17
 */

@Service
public class OrderService {
	
	@Value("${price.default}")
	private Double priceDefault;
	
	@Value("${price.discount}")
	private Double priceDiscount;	

	@Autowired
	private ProductClient productClient;
	
	private List<Order> orders = new ArrayList<>();
	
	@HystrixCommand(fallbackMethod="prepareFallback")
	public Order prepare(Order order) {
		Product p = productClient.findById(order.getProductId());
		double discountedPrice = p.getPrice() - p.getPrice() * priceDiscount / 100;
		order.setPrice(discountedPrice);		
		orders.add(order);		
		return order;
	}
	
	public Order prepareFallback(Order order) {	
		order.setPrice(priceDefault);		
		orders.add(order);		
		return order;
	}
}
