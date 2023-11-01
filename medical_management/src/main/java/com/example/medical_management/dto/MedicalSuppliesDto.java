package com.example.medical_management.dto;

import com.example.medical_management.model.medical_supplies.Category;
import com.example.medical_management.model.medical_supplies.Supplier;
import com.example.medical_management.model.medical_supplies.Unit;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class MedicalSuppliesDto {
    private int id;
    private String code;
    private String name;
    private long price;
    private Date importDate;
    private String expiry;
    private Category category;
    private Supplier supplier;
    private Unit unit;
}
