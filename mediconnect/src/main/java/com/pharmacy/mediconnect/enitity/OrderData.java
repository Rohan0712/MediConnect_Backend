package com.pharmacy.mediconnect.enitity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.google.api.client.util.DateTime;

@Component
public class OrderData implements Serializable {
    private String orderID;
    private String userID;
    private String orderDate;
    private String storeAddress;
    private BigInteger totalAmount;
    private String referenceNumber;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getStoreAddress() {
		return storeAddress;
	}
	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}
	public BigInteger getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigInteger totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	
    
}
