package com.example.medical_management.controller.rest_medical_controller;

import com.example.medical_management.dto.MedicalSuppliesDto;
import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.medical_supplies.Category;
import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import com.example.medical_management.model.medical_supplies.Supplier;
import com.example.medical_management.model.medical_supplies.Unit;
import com.example.medical_management.service.account.AccountService;
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

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

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
    private AccountService accountService;

    @GetMapping("/getAllSupply")
    public ResponseEntity<List<MedicalSupplies>> getMedicalSupplies() {
        List<MedicalSupplies> medicalSupplies = medicalService.findAllSupply();
        if (medicalSupplies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalSupplies, HttpStatus.OK);
    }

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

        medicalService.update(medicalSupplies);
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

//    @GetMapping("/oldSupplies")
//    public ResponseEntity<Page<MedicalSupplies>> getSupplyByName (@RequestParam(defaultValue = "0") int page,
//                                                                  @RequestParam(defaultValue = "") int size,
//                                                                  @RequestParam(name = "name") String nameSearch) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<MedicalSupplies> oldSupplies = medicalService.findByName(pageable, nameSearch);
//
//        if (oldSupplies.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(oldSupplies, HttpStatus.OK);
//    }
//
//    @GetMapping("/oldSupplies")
//    public ResponseEntity<Page<MedicalSupplies>> getSupplyByTypes (@RequestParam(defaultValue = "0") int page,
//                                                                  @RequestParam(defaultValue = "") int size,
//                                                                  @RequestParam(name = "typeId") long idSearch) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<MedicalSupplies> oldSupplies = medicalService.findByType(pageable, idSearch);
//
//        if (oldSupplies.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(oldSupplies, HttpStatus.OK);
//    }
//
//    @GetMapping("/oldSupplies")
//    public ResponseEntity<Page<MedicalSupplies>> getSupplyBySupplier (@RequestParam(defaultValue = "0") int page,
//                                                                  @RequestParam(defaultValue = "") int size,
//                                                                  @RequestParam(name = "supplierId") long supplierIdSearch) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<MedicalSupplies> oldSupplies = medicalService.findBySupplier(pageable, supplierIdSearch);
//
//        if (oldSupplies.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(oldSupplies, HttpStatus.OK);
//    }
//
//    @GetMapping("/oldSupplies")
//    public ResponseEntity<Page<MedicalSupplies>> getSupplyByDate (@RequestParam(defaultValue = "0") int page,
//                                                                  @RequestParam(defaultValue = "") int size,
//                                                                  @RequestParam(name = "fromDate") Date fromDateSearch,
//                                                                  @RequestParam(name = "toDate") Date toDateSearch) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<MedicalSupplies> oldSupplies = medicalService.findByDate(pageable, fromDateSearch, toDateSearch);
//
//        if (oldSupplies.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(oldSupplies, HttpStatus.OK);
//    }

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

//    @GetMapping("/statistic-supplies/{lastDate}")
//    public ResponseEntity<List<MedicalSupplies>> getStatisticSupplies(@PathVariable String lastDate) {
//        List<Object[]> result = medicalService.findAllBetweenDays(lastDate);
//        List<MedicalSupplies> suppliesList = new ArrayList<>();
//
//        for (Object[] row : result) {
//            MedicalSupplies item = new MedicalSupplies();
//
//            item.setCode((String) row[0]);
//            item.setExpiry((Date) row[1]);
//            item.setImportDate((Date) row[2]);
//            item.setName((String) row[3]);
//            item.setQuantity((String) row[4]);
//
//            suppliesList.add(item);
//        }
//
//        if (suppliesList == null || suppliesList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(suppliesList, HttpStatus.OK);
//    }

    @GetMapping("/lastSupply")
    public ResponseEntity<?> getLastSupply() {
        MedicalSupplies lastSupply = medicalService.getLastSupply();
        if (lastSupply == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lastSupply, HttpStatus.OK);
    }
}
