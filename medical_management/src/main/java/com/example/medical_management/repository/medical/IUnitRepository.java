package com.example.medical_management.repository.medical;

import com.example.medical_management.model.medical_supplies.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUnitRepository extends JpaRepository<Unit, Long> {
}
