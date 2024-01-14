package com.pharmacy.mediconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.mediconnect.enitity.Order;

@Repository
public interface OrderRespository extends JpaRepository<Order, String> {
    Order findOrderByOrderID(String orderID);
}
