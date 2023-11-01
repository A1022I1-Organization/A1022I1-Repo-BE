package com.example.medical_management.service.medical.impl;

import com.example.medical_management.model.medical_supplies.Supplier;
import com.example.medical_management.repository.medical.ISupplierRepository;
import com.example.medical_management.service.medical.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private ISupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAllSupplier() {
        return supplierRepository.findAll();
    }
}
