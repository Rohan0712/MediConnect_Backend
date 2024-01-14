package com.pharmacy.mediconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.mediconnect.enitity.Doctor;
import com.pharmacy.mediconnect.enitity.Medicine;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, String> {
    Doctor findDoctorByName(String name);
}
