package com.orderapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {
private Integer orderId;
private int userId;
private List<String> itemNames;
private double totalPrice;
private String status;//PLACED,CONFIRMED,CANCELLED
}
