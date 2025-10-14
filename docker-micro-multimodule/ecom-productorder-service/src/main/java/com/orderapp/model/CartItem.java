package com.orderapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CartItem {
	
	private Integer cartItemId;
	private int productId;
	private String productName;
	private double price;
	private int quantity;
	
	
	
}
