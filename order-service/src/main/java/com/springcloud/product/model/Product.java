package com.springcloud.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author afiore
 * Created on 2018-12-17
 */

@AllArgsConstructor
@Getter
public class Product {

	private Integer id;
	private String name;
	private Double price;

}
