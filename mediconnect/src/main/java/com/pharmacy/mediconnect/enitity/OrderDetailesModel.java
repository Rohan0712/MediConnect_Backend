package com.pharmacy.mediconnect.enitity;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderDetailesModel implements Serializable {
	
	private OrderData order;
	private List<OrderDetails> orderDetailsList;
	public OrderData getOrder() {
		return order;
	}
	public void setOrder(OrderData order) {
		this.order = order;
	}
	public List<OrderDetails> getOrderDetailsList() {
		return orderDetailsList;
	}
	public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
		this.orderDetailsList = orderDetailsList;
	}
}
