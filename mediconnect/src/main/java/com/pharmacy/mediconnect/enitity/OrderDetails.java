package com.pharmacy.mediconnect.enitity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.api.client.util.DateTime;

@Entity
@Table(name="OrderDetails")
public class OrderDetails implements Serializable {
	@Id
	@Column(name="orderDetailID")
    private String orderDetailID;
	@Column(name="orderID")
    private String orderID;
	@Column(name="medicineID")
	private Integer medicineID;
	@Column(name="quantity")
	private Integer quantity;
	@Column(name="name")
    private String name;
	@Column(name="subtotal")
    private BigInteger subtotal;
	public String getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Integer getMedicineID() {
		return medicineID;
	}
	public void setMedicineID(Integer medicineID) {
		this.medicineID = medicineID;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigInteger getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigInteger subtotal) {
		this.subtotal = subtotal;
	}
}
