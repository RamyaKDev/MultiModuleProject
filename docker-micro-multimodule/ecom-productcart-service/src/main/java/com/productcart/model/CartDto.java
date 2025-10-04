package com.productcart.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDto implements Type{
	private Integer cartId;
	private int userId;
    private double totalPrice;
    List<CartItem> cartItems;
}
