package com.example.medical_management.service.medical.impl;

import com.example.medical_management.model.medical_supplies.Unit;
import com.example.medical_management.repository.medical.IUnitRepository;
import com.example.medical_management.service.medical.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements IUnitService {

    @Autowired
    private IUnitRepository unitRepository;

    @Override
    public List<Unit> findAllUnit() {
        return unitRepository.findAll();
    }
}
