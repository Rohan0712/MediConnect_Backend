package com.pharmacy.mediconnect.enitity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Support")
public class Support implements Serializable {
	@Id
	@Column(name="supportId")
	private Integer supportId;
	@Column(name="name")
    private String name;
	@Column(name="email")
    private String email;
	@Column(name="message")
    private String message;
	public Integer getSupportId() {
		return supportId;
	}
	public void setSupportId(Integer supportId) {
		this.supportId = supportId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
