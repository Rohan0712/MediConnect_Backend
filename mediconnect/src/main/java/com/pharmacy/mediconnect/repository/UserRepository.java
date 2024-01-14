package com.pharmacy.mediconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pharmacy.mediconnect.enitity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findUserByEmail(String email);
	User findUserByUserID(String userID);
}
