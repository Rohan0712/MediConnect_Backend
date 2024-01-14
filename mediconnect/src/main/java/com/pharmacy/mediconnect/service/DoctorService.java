package com.pharmacy.mediconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.mediconnect.enitity.Doctor;
import com.pharmacy.mediconnect.enitity.Medicine;
import com.pharmacy.mediconnect.repository.DoctorRepository;

@Service
public class DoctorService{

	@Autowired
	DoctorRepository doctorRepository;
	
	public Doctor fetchDoctorByName(String name) {
		return doctorRepository.findDoctorByName(name);
	}

	public List<Doctor> fetchDoctorList() {
		return doctorRepository.findAll();
	}
	
}
