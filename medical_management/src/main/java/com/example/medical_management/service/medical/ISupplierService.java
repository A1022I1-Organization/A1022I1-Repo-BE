package com.example.medical_management.service.medical;

import com.example.medical_management.model.medical_supplies.Category;
import com.example.medical_management.model.medical_supplies.Supplier;

import java.util.List;

public interface ISupplierService {
    List<Supplier> findAllSupplier();
}
