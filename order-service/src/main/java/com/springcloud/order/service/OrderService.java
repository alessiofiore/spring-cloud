package com.springcloud.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Autowired
	private ProductClient productClient;
	
	private List<Order> orders = new ArrayList<>();
	
	public Order prepare(Order order) {
		Product p = productClient.findById(order.getProductId());
		
		order.setPrice(p.getPrice());
		
		orders.add(order);
		
		return order;
	}
}
