package com.notifyapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OrderEvent {
private Integer orderEventId;
private Order order;
private String status;//NEW, FAILED, SUCCESS

}
