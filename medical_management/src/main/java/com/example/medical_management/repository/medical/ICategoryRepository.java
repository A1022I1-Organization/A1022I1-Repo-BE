package com.example.medical_management.repository.medical;

import com.example.medical_management.model.medical_supplies.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
