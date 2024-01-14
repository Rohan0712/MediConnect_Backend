package com.pharmacy.mediconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.mediconnect.enitity.Doctor;
import com.pharmacy.mediconnect.enitity.User;
import com.pharmacy.mediconnect.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	UserRepository userRepository;
	
	public User fetchUserByEmail(String email) {
		User user = new User();
		user = userRepository.findUserByEmail(email);
		if(user!= null) {
			return user;
		}else {			
			user = userRepository.findUserByUserID(email);
			if(user!=null) {
				return user;
			}
		}
		return user;
	}

	public User fetchUserByUserId(String userId) {
		return userRepository.findUserByUserID(userId);
	}
	
	public List<User> fetchUserList() {
		return userRepository.findAll();
	}

	public Boolean updateUserDetails(String userId) {
		User user  = new User();
		user = userRepository.findUserByUserID(userId);
		Boolean verificationFlag = user.isAccountVerification();
		user.setAccountVerification(!verificationFlag);
		if(userRepository.save(user) != null)
		{
			return true;
		}
		return false;
	}

	public String registerUser(User user) {
		String response= "Failed";
		if(userRepository.findUserByUserID(user.getUserID()) != null) {
				return "Username Already Exist";
		}else if(userRepository.findUserByEmail(user.getEmail()) != null) {
				return "Email Already Exist";
		}
		else {			
			if(userRepository.save(user) != null) {
				response ="Success";
				return response;
			}else {
				return response;
			}
		}
	}
	
}
