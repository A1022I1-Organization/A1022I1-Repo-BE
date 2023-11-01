package com.example.medical_management.controller;

import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import com.example.medical_management.service.medical.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("")
    public ResponseEntity<Page<MedicalSupplies>> getAll(@RequestBody Pageable pageable) {
        Page<MedicalSupplies> medicalSupplies = medicalService.findPage(pageable);
        if (medicalSupplies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalSupplies, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        MedicalSupplies medicalSupplies = medicalService.findByMedical(id);
        if (medicalSupplies==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            medicalService.delete(medicalSupplies);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getDetail(@PathVariable int id) {
        MedicalSupplies medical = medicalService.findByMedical(id);
        if (medical==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            medicalService.findByMedical(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
