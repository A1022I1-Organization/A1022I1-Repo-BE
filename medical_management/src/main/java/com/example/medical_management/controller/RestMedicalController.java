package com.example.medical_management.controller;

import com.example.medical_management.dto.MedicalSuppliesDto;
import com.example.medical_management.model.medical_supplies.Category;
import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import com.example.medical_management.model.medical_supplies.Supplier;
import com.example.medical_management.model.medical_supplies.Unit;
import com.example.medical_management.service.medical.ICategoryService;
import com.example.medical_management.service.medical.IMedicalService;
import com.example.medical_management.service.medical.ISupplierService;
import com.example.medical_management.service.medical.IUnitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("api/medical")
public class RestMedicalController {

    @Autowired
    private IMedicalService medicalService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private IUnitService unitService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody MedicalSuppliesDto medicalSuppliesDto,
                                    BindingResult bindingResult) {

        new MedicalSuppliesDto().validate(medicalSuppliesDto, bindingResult);
        Map<String, Object> errorInput = new HashMap<>();

        //Check validate
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorInput.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorInput, HttpStatus.BAD_REQUEST);
        }

        MedicalSupplies medicalSupplies = new MedicalSupplies();
        BeanUtils.copyProperties(medicalSuppliesDto, medicalSupplies);

        medicalService.add(medicalSupplies);
        errorInput.put("message", "successful");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<?> update(@RequestBody MedicalSuppliesDto medicalSuppliesDto,
                                    BindingResult bindingResult) {
        new MedicalSuppliesDto().validate(medicalSuppliesDto, bindingResult);
        Map<String, Object> errorInput = new HashMap<>();

        //Check validate
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorInput.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorInput, HttpStatus.BAD_REQUEST);
        }

        MedicalSupplies medicalSupplies = new MedicalSupplies();
        BeanUtils.copyProperties(medicalSuppliesDto, medicalSupplies);

        medicalService.add(medicalSupplies);
        errorInput.put("message", "successful");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categories = categoryService.findAllCategory();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Supplier>> getSupplier() {
        List<Supplier> suppliers = supplierService.findAllSupplier();
        if (suppliers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Unit>> getUnit() {
        List<Unit> units = unitService.findAllUnit();
        if (units.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(units, HttpStatus.OK);
    }
}
