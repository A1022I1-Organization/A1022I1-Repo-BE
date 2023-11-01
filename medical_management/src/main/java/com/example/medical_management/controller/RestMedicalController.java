package com.example.medical_management.controller;

import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import com.example.medical_management.service.medical.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("api/medical")
public class RestMedicalController {

    @Autowired
    private IMedicalService medicalService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody MedicalSupplies medicalSupplies) {
        try {
            medicalService.add(medicalSupplies);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("")
    public ResponseEntity<?> update(@RequestBody MedicalSupplies medicalSupplies) {
        try {
            medicalService.add(medicalSupplies);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
