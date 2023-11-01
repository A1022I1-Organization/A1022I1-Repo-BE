package com.example.medical_management.service.medical.impl;

import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import com.example.medical_management.repository.medical.IMedicalRepository;
import com.example.medical_management.service.medical.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicalServiceImpl implements IMedicalService {

    @Autowired
    private IMedicalRepository medicalRepository;
    @Override
    public MedicalSupplies add(MedicalSupplies medical) {
        return medicalRepository.save(medical);
    }

    @Override
    public MedicalSupplies update(MedicalSupplies medical) {
        return medicalRepository.save(medical);
    }

    @Override
    public Page<MedicalSupplies> findPage(Pageable pageable) {
        return null;
    }

    @Override
    public MedicalSupplies findByMedical(int id) {
        return null;
    }

    @Override
    public void delete(MedicalSupplies medicalSupplies) {

    }
}
