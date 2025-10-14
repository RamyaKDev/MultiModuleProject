package com.orderapp.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.orderapp.model.Cart;

@FeignClient(name="product-cart",url="${product-cart.service.url}")
public interface ICartFeign {
	@GetMapping("/cart-service/v1/cart-info/view-cart/userId/{userId}")
	Cart getCartByUserId(@PathVariable int userId);
}
