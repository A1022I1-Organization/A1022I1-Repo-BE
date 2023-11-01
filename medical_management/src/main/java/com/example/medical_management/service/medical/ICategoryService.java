package com.example.medical_management.service.medical;

import com.example.medical_management.model.medical_supplies.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();
}
