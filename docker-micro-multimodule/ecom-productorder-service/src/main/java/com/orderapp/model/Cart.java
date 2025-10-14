package com.orderapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Cart {
	
	private Integer cartId;
	private int userId;
    private double totalPrice;
	List<CartItem> cartItems;

}
