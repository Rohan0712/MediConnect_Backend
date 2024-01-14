package com.pharmacy.mediconnect.enitity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User implements Serializable {
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userID")
	private String userID;
	@Column(name="firstName")
    private String firstName;
	@Column(name="lastName")
    private String lastName;
	@Column(name="email")
    private String email;
	@Column(name="phone")
    private String phone;
	@Column(name="address")
    private String address;
	@Column(name="accountVerification")
    private boolean accountVerification;
	@Column(name="password")
	private String password;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isAccountVerification() {
		return accountVerification;
	}
	public void setAccountVerification(boolean accountVerification) {
		this.accountVerification = accountVerification;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
