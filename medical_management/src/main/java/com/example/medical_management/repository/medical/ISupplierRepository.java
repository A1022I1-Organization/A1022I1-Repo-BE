package com.example.medical_management.repository.medical;

import com.example.medical_management.model.medical_supplies.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {
}
