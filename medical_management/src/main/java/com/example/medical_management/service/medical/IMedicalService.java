package com.example.medical_management.service.medical;

import com.example.medical_management.dto.MedicalSuppliesDto;
import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

import java.util.List;

public interface IMedicalService {
    MedicalSupplies add(MedicalSupplies medical);
    MedicalSupplies update(MedicalSupplies medical);
    Page<MedicalSupplies> findOldSupplies (Pageable pageable);
    Page<MedicalSupplies> findNewSupplies (Pageable pageable);
    MedicalSupplies findByMedical(Long id);
    void delete (MedicalSupplies medicalSupplies);
    List<Object[]> findAllBetweenDays(String lastDateInput);
    void delete (long id);

    List<MedicalSupplies> getAllListWithPage(String category, int page);
    List<MedicalSupplies> findAllSupply();
    MedicalSupplies getLastSupply();
}
