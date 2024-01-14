package com.pharmacy.mediconnect.service;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.mediconnect.enitity.Order;
import com.pharmacy.mediconnect.enitity.OrderDetailesModel;
import com.pharmacy.mediconnect.enitity.OrderDetails;
import com.pharmacy.mediconnect.repository.OrderDetailsRespository;
import com.pharmacy.mediconnect.repository.OrderRespository;

@Service
public class OrderService{

	@Autowired
	OrderRespository orderRespository;
	
	@Autowired
	OrderDetailsRespository orderDetailsRespository;
	
	private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final SecureRandom random = new SecureRandom();
	
	public Order fetchOrderByOrderId(String orderId) {
		return orderRespository.findOrderByOrderID(orderId);
	}

	public String saveOrderDetails(OrderDetailesModel orderDetailesModel) throws ParseException {
		int val = 0;
		Order order = new Order();
		Date date = new Date();  
		order.setOrderDate(date);
		order.setOrderID(orderDetailesModel.getOrder().getOrderID());
		order.setReferenceNumber(orderDetailesModel.getOrder().getReferenceNumber());
		order.setStoreAddress(orderDetailesModel.getOrder().getStoreAddress());
		order.setTotalAmount(orderDetailesModel.getOrder().getTotalAmount());
		order.setUserID(orderDetailesModel.getOrder().getUserID());
		if(orderRespository.save(order)!=null) {	
			val = ++val;
			for(OrderDetails orderDetails: orderDetailesModel.getOrderDetailsList()) {
				String randomValue = generateRandomAlphanumeric(8);
				orderDetails.setOrderDetailID(randomValue.concat("3ASD45")+val);
				if(orderDetailsRespository.save(orderDetails)==null) {
					return "Failed";
				}
			}
			return "Success";
		}
		return "Failed";
	}
	
	public static String generateRandomAlphanumeric(int length) {
		StringBuilder sb = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(ALPHANUMERIC.length());
			char randomChar = ALPHANUMERIC.charAt(randomIndex);
			sb.append(randomChar);
		}
		
		return sb.toString();
	}
}
