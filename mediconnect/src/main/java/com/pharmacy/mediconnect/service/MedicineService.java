package com.pharmacy.mediconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.mediconnect.enitity.Medicine;
import com.pharmacy.mediconnect.repository.MedicineRepository;

@Service
public class MedicineService{

	@Autowired
	MedicineRepository medicineRepository;
	
	public Medicine fetchMedicineById(Integer id) {
		return medicineRepository.findMedicineByMedicineId(id);
	}

	public List<Medicine> fetchMedicineList() {
		return medicineRepository.findAll();
	}
	
}
