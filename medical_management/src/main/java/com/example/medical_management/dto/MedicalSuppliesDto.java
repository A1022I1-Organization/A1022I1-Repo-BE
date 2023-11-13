package com.example.medical_management.dto;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.medical_supplies.Category;
import com.example.medical_management.model.medical_supplies.MedicalSupplies;
import com.example.medical_management.model.medical_supplies.Supplier;
import com.example.medical_management.model.medical_supplies.Unit;
import com.example.medical_management.repository.medical.IMedicalRepository;
import com.example.medical_management.service.medical.IMedicalService;
import com.example.medical_management.service.medical.impl.MedicalServiceImpl;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

public class MedicalSuppliesDto implements Validator {
    private Long id;
    private String code;
    private String name;
    private String picture;
    private String price;
    @NotNull(message = "Ngày nhập hàng không được để trống")
    private Date importDate;
    @NotNull(message = "Hạn sử dụng không được để trống")
    private Date expiry;
    private String quantity;
    private Category category;
    private Supplier supplier;
    private Unit unit;
    private Account account;

    public MedicalSuppliesDto() {
    }

    public MedicalSuppliesDto(Long id, String code, String name, String picture, String price, Date importDate, Date expiry, String quantity, Category category, Supplier supplier, Unit unit, Account account) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.picture = picture;
        this.price = price;
        this.importDate = importDate;
        this.expiry = expiry;
        this.quantity = quantity;
        this.category = category;
        this.supplier = supplier;
        this.unit = unit;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MedicalSuppliesDto medicalDto = (MedicalSuppliesDto) target;

        long millis = System.currentTimeMillis();
        java.sql.Date nowDate = new java.sql.Date(millis);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        calendar.add(Calendar.MONTH, 6);

        Date newDate = new Date(calendar.getTimeInMillis());

        // Validate Ảnh (picture)
        if (medicalDto.getPicture().isEmpty()) {
            errors.rejectValue("picture", null, "Ảnh vật tư không được để trống");
        }

        // Validate Mã vật tư (code)
        if (medicalDto.getCode().isEmpty()) {
            errors.rejectValue("code", null, "Mã vật tư không được để trống");
        } else if (!medicalDto.getCode().matches("^MVT-[0-9]{4}$")){
            errors.rejectValue("code", null, "Mã vật tư phải theo định dạng MVT-XXXX");
        }
//         Validate Tên vật tư (name)
        if (medicalDto.getName().isEmpty()) {
            errors.rejectValue("name", null, "Tên vật tư không được để trống");
        } else if (medicalDto.getName().length() > 100 || medicalDto.getName().length() < 2){
            errors.rejectValue("name", null, "Tên vật tư không được lớn hơn 100 và bé hơn 2 ký tự");
        }
//         Validate Giá thành (price)
        if (medicalDto.getPrice().isEmpty()) {
            errors.rejectValue("name", null, "Tên vật tư không được để trống");
        } else if (!medicalDto.getPrice().matches("^[1-9]\\d*$")){
            errors.rejectValue("name", null, "Giá thành phải là số nguyên dương");
        }
//         Validate Số lượng (quantity)
        if (medicalDto.getPrice().isEmpty()) {
            errors.rejectValue("name", null, "Tên vật tư không được để trống");
        } else if (!medicalDto.getPrice().matches("^[1-9]\\d*$")){
            errors.rejectValue("name", null, "Giá thành phải là số nguyên dương");
        }
        // Validate Ngày nhập hàng (importDate)
        if (medicalDto.getImportDate().compareTo(nowDate) > 0) {
            errors.rejectValue("importDate", null, "Ngày nhập hàng không lớn hơn ngày hiện tại");
        }
        // Validate Hạn sử dụng (expiry)
        if (medicalDto.getExpiry().compareTo(newDate) < 0 || medicalDto.getExpiry().compareTo(newDate) == 0) {
            errors.rejectValue("expiry", null, "Hạn sử dụng phải hơn 6 tháng so với ngày hiện tại");
        }
    }
}
