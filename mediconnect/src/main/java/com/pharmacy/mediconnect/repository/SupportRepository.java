package com.pharmacy.mediconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.mediconnect.enitity.Doctor;
import com.pharmacy.mediconnect.enitity.Support;

@Repository
public interface SupportRepository extends JpaRepository<Support, Integer> {
    Support findByName(String name);
    Support findBySupportId(Integer supportId);
}
