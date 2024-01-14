package com.pharmacy.mediconnect.enitity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medicine")
public class Medicine implements Serializable {
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medicineId")
	private Integer medicineId;
	@Column(name="quantity")
	private Integer quantity;
	@Column(name="name")
    private String name;
	@Column(name="content")
    private String content;
	@Column(name="description")
    private String description;
	@Column(name="imageUrl")
    private String imageUrl;
	@Column(name="price")
    private BigInteger price;
	
	public Integer getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Integer medicineId) {
		this.medicineId = medicineId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public BigInteger getPrice() {
		return price;
	}
	public void setPrice(BigInteger price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
   
}
