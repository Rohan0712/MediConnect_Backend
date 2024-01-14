package com.pharmacy.mediconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pharmacy.mediconnect.enitity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
    Medicine findMedicineByMedicineId(Integer medicineId);
}
