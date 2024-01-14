package com.pharmacy.mediconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.mediconnect.enitity.Order;
import com.pharmacy.mediconnect.enitity.OrderDetails;
import com.pharmacy.mediconnect.repository.OrderDetailsRespository;
import com.pharmacy.mediconnect.repository.OrderRespository;

@Service
public class OrderDetailsService{

	@Autowired
	OrderDetailsRespository orderDetailsRespository;
	
	public OrderDetails fetchOrderByOrderId(String orderDetailsId) {
		return orderDetailsRespository.findOrderDetailsByOrderDetailID(orderDetailsId);
	}	
}
