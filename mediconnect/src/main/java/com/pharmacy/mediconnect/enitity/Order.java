package com.pharmacy.mediconnect.enitity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.api.client.util.DateTime;

@Entity
@Table(name="Orders")
public class Order implements Serializable {
	@Id
	@Column(name="orderID")
    private String orderID;
	@Column(name="userID")
    private String userID;
	@Column(name="orderDate")
    private Date orderDate;
	@Column(name="storeAddress")
    private String storeAddress;
	@Column(name="totalAmount")
    private BigInteger totalAmount;
	@Column(name="referenceNumber")
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date date) {
		this.orderDate = date;
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
