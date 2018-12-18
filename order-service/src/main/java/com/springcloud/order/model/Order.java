package com.springcloud.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author afiore
 * Created on 2018-12-17
 */

@AllArgsConstructor
@Getter
@Setter
public class Order {

	private Integer id;
	private Integer customerId;
	private Integer productId;
	private Double price;

}
