package com.example.medical_management.service.medical;

import com.example.medical_management.dto.MedicalSuppliesDto;
import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

import java.util.List;

public interface IMedicalService {
    MedicalSupplies add(MedicalSupplies medical);
    MedicalSupplies update(MedicalSupplies medical);
    Page<MedicalSupplies> findOldSupplies (Pageable pageable);
    Page<MedicalSupplies> findNewSupplies (Pageable pageable);
    Page<MedicalSupplies> findByType (Pageable pageable, long id);
    Page<MedicalSupplies> findBySupplier (Pageable pageable, long id);
    Page<MedicalSupplies> findByDate (Pageable pageable, Date fromDate, Date toDate);
    Page<MedicalSupplies> findByName (Pageable pageable, String name);
    MedicalSupplies findByMedical(Long id);
    void delete (MedicalSupplies medicalSupplies);
    List<Object[]> findAllBetweenDays(String lastDateInput);
    void delete (long id);

    List<MedicalSupplies> findExpiredSupplies();
    List<MedicalSupplies> getAllListWithPage(String category, int page, String nameSort, String priceSort);
    boolean checkExitsCode(String code);
    List<MedicalSupplies> getAllListWithPage(String category, int page);
    List<MedicalSupplies> findAllSupply();
    MedicalSupplies getLastSupply();

}
