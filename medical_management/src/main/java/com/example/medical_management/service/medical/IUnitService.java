package com.example.medical_management.service.medical;

import com.example.medical_management.model.medical_supplies.Category;
import com.example.medical_management.model.medical_supplies.Unit;

import java.util.List;

public interface IUnitService {
    List<Unit> findAllUnit();
}
