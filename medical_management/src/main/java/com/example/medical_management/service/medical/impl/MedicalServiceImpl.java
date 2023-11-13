package com.example.medical_management.service.medical.impl;

import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import com.example.medical_management.repository.medical.IMedicalRepository;
import com.example.medical_management.service.medical.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Page<MedicalSupplies> findOldSupplies(Pageable pageable) {
        return medicalRepository.findOldSupplies(pageable);
    }

    @Override
    public Page<MedicalSupplies> findNewSupplies(Pageable pageable) {
        return medicalRepository.findNewSupplies(pageable);
    }

    @Override
    public MedicalSupplies findByMedical(Long id) {
        return medicalRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(MedicalSupplies medicalSupplies) {
        medicalRepository.delete(medicalSupplies);
    }

    @Override
    public List<MedicalSupplies> findExpiredSupplies() {
        return medicalRepository.findExpiredSupplies();
    }

    @Override
    public List<MedicalSupplies> getAllListWithPage(String category, int page) {
       return medicalRepository.getAllListWithPage(category,page);
    }

    @Override
    public boolean checkExitsCode(String code) {
        return medicalRepository.existsByCode(code);
    }


}
