package com.example.medical_management.dto;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.medical_supplies.Category;
import com.example.medical_management.model.medical_supplies.Supplier;
import com.example.medical_management.model.medical_supplies.Unit;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

public class MedicalSuppliesDto implements Validator {
    private int id;
    private String code;
    private String name;
    private String picture;
    private long price;
    private java.sql.Date importDate;
    private java.sql.Date expiry;
    private int quantity;
    private Category category;
    private Supplier supplier;
    private Unit unit;
//    private Account account;

    public MedicalSuppliesDto() {
    }

    public MedicalSuppliesDto(int id, String code, String name, String picture, long price, Date importDate, Date expiry, int quantity, Category category, Supplier supplier, Unit unit) {
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
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    private boolean isPositiveInteger(String value) {
        return Pattern.matches("^\\d+$", value);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MedicalSuppliesDto medicalDto = (MedicalSuppliesDto) target;
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        // Validate Mã vật tư (code)
        if (medicalDto.getCode().isEmpty() || !medicalDto.getCode().matches("^MVT-[0-9]{4}$")) {
            errors.rejectValue("code", null, "Mã vật tư phải theo định dạng MVT-XXXX");
        }
        // Validate Tên vật tư (name)
        if (medicalDto.getName().isEmpty() || medicalDto.getName().length() > 100) {
            errors.rejectValue("name", null, "Tên vật tư không được vượt quá 100 ký tự");
        }
        // Validate Giá thành (price)
        if (medicalDto.getPrice() < 0 || !isPositiveInteger(String.valueOf(medicalDto.getPrice()))) {
            errors.rejectValue("price", null, "Giá thành phải là số nguyên dương");
        }
        // Validate Ngày nhập hàng (importDate)
//        try {
//            Date expiryDate = sdf.parse(medicalDto.getImportDate().toString());
//            Date currentDate = new Date();
//            if (expiryDate.before(currentDate)) {
//                errors.rejectValue("importDate", null, "Ngày nhập hàng phải lớn hơn ngày hiện tại");
//            }
//        } catch (ParseException e) {
//            errors.rejectValue("importDate", null, "Ngày nhập hàng phải theo định dạng dd/MM/yy");
//        }
        // Validate Hạn sử dụng (expiry)
//        try {
//            Date expiryDate = sdf.parse(medicalDto.getExpiry().toString());
//            Date currentDate = new Date();
//            if (expiryDate.before(currentDate)) {
//                errors.rejectValue("expiry", null, "Hạn sử dụng phải lớn hơn ngày hiện tại");
//            }
//            Date importDate = sdf.parse(medicalDto.getImportDate().toString());
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(importDate);
//            calendar.add(Calendar.MONTH, 6); // Kiểm tra ít nhất 6 tháng
//            Date sixMonthsLater = calendar.getTime();
//            if (expiryDate.before(sixMonthsLater)) {
//                errors.rejectValue("expiry", null, "Hạn sử dụng phải lớn hơn ngày nhập hàng ít nhất 6 tháng");
//            }
//            calendar.add(Calendar.YEAR, 1); // Kiểm tra ít nhất 1 năm
//            Date oneYearLater = calendar.getTime();
//            if (expiryDate.before(oneYearLater)) {
//                errors.rejectValue("expiry", null, "Hạn sử dụng phải lớn hơn ngày nhập hàng ít nhất 1 năm");
//            }
//        } catch (ParseException e) {
//            errors.rejectValue("expiry", null, "Hạn sử dụng phải theo định dạng dd/MM/yy");
//        }
        // Validate Số lượng (quantity)
        if (medicalDto.getQuantity() < 0) {
            errors.rejectValue("quantity", "Số lượng phải là số nguyên dương");
        }
    }
}
