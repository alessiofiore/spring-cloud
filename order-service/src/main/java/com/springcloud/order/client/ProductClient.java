package com.springcloud.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springcloud.product.model.Product;

/**
 *
 * @author afiore
 * Created on 2018-12-18
 */

@FeignClient("product-service")
public interface ProductClient {

	@GetMapping("/{id}")
	public Product findById(@PathVariable Integer id);
}
