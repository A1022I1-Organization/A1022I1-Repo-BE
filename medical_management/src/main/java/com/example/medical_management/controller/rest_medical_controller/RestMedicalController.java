package com.example.medical_management.controller.rest_medical_controller;

import com.example.medical_management.dto.MedicalSuppliesDto;
import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.medical_supplies.Category;
import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import com.example.medical_management.model.medical_supplies.Supplier;
import com.example.medical_management.model.medical_supplies.Unit;
import com.example.medical_management.service.account.IAccountService;
import com.example.medical_management.service.medical.ICategoryService;
import com.example.medical_management.service.medical.IMedicalService;
import com.example.medical_management.service.medical.ISupplierService;
import com.example.medical_management.service.medical.IUnitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/supply")
public class RestMedicalController {

    @Autowired
    private IMedicalService medicalService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private IUnitService unitService;

    @Autowired
    private IAccountService accountService;

    @PostMapping("/add")
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

    @PatchMapping("/update")
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

    @GetMapping("/getCategory")
    public ResponseEntity<List<Category>> getCategory() {
        List<Category> categories = categoryService.findAllCategory();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/getSupplier")
    public ResponseEntity<List<Supplier>> getSupplier() {
        List<Supplier> suppliers = supplierService.findAllSupplier();
        if (suppliers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/getUnit")
    public ResponseEntity<List<Unit>> getUnit() {
        List<Unit> units = unitService.findAllUnit();
        if (units.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(units, HttpStatus.OK);
    }

    @GetMapping("/getAccount")
    public ResponseEntity<List<Account>> getAccount() {
        List<Account> accounts = accountService.findAllAccount();
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/oldSupplies")
    public ResponseEntity<Page<MedicalSupplies>> getOldSupplies(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MedicalSupplies> oldSupplies = medicalService.findOldSupplies(pageable);

        if (oldSupplies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(oldSupplies, HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<MedicalSupplies>> getPageSupplies(@RequestParam(name = "c",defaultValue = "") String category,
                                                                 @RequestParam(name = "p",defaultValue = "6") int page) {
         List<MedicalSupplies> oldSupplies = medicalService.getAllListWithPage(category,page);

        if (oldSupplies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(oldSupplies, HttpStatus.OK);
    }

    @GetMapping("/newSupplies")
    public ResponseEntity<Page<MedicalSupplies>> getNewSupplies(@RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MedicalSupplies> newSupplies = medicalService.findNewSupplies(pageable);

        if (newSupplies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(newSupplies, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        MedicalSupplies medicalSupplies = medicalService.findByMedical(id);
        if (medicalSupplies==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            medicalService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id) {
        MedicalSupplies supply = medicalService.findByMedical(id);
        if (supply==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            medicalService.findByMedical(id);
            return new ResponseEntity<>(supply, HttpStatus.OK);
        }
    }

    @GetMapping("/expired-supplies")
    public ResponseEntity<List<MedicalSupplies>> getExpriredSupplies() {
        List<MedicalSupplies> expiredSupplies = medicalService.findExpiredSupplies();
        if (expiredSupplies == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(expiredSupplies, HttpStatus.OK);
    }

}
