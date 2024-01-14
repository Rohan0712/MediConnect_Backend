package com.pharmacy.mediconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.mediconnect.enitity.OrderDetails;

@Repository
public interface OrderDetailsRespository extends JpaRepository<OrderDetails, String> {
	OrderDetails findOrderDetailsByOrderDetailID(String orderDetailID);
}
