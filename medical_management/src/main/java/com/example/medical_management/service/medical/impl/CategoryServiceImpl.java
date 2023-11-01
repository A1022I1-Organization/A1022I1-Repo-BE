package com.example.medical_management.service.medical.impl;

import com.example.medical_management.model.medical_supplies.Category;
import com.example.medical_management.repository.medical.ICategoryRepository;
import com.example.medical_management.service.medical.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
