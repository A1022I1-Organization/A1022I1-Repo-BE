package com.example.medical_management.service.medical;

import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicalService {
    MedicalSupplies add(MedicalSupplies medical);
    MedicalSupplies update(MedicalSupplies medical);
    Page<MedicalSupplies> findPage (Pageable pageable);
    MedicalSupplies findByMedical(Long id);
    void delete (MedicalSupplies medicalSupplies);
}
