package com.example.medical_management.repository.medical;

import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicalRepository extends JpaRepository<MedicalSupplies, Long> {
}
