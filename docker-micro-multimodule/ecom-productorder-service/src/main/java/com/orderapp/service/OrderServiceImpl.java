package com.orderapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.orderapp.feign.ICartFeign;
import com.orderapp.model.Cart;
import com.orderapp.model.Order;
import com.orderapp.model.OrderEvent;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private KafkaTemplate<String, OrderEvent> kafkaTemplate;
	@Value("${order.topic.name}")
	private String topicName;
	
	@Autowired
	private ICartFeign cartFeign;
	
	@Override
	public String placeOrder(int userId) {
		// get the cart using userId from cartService
		Cart cart=cartFeign.getCartByUserId(userId);
		//check if cart is null
		if(cart==null)
		throw new RuntimeException("empty cart");
		//create a order object
		Order order=new Order();
		order.setOrderId(1);
		order.setUserId(userId);
		order.setStatus("PLACED");		
		order.setTotalPrice(cart.getTotalPrice());
		//we dont want to show all the details about product 
		//just displaying product name
		List<String> items=cart.getCartItems().stream()
					.map(cartItem->cartItem.getProductName()+" : "+cartItem.getQuantity())
					.toList();
		order.setItemNames(items);
		//order object should be saved in db
		//create an order event to store in kafka
		OrderEvent orderEvent=new OrderEvent();
		orderEvent.setOrderEventId(100);
		orderEvent.setStatus("SUCCESS");		
		orderEvent.setOrder(order);
		//send the order event to kafka server
		kafkaTemplate.send(topicName,orderEvent);
		
		return "order placed and email sent";
	}

}
