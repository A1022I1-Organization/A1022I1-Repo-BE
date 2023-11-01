package com.example.medical_management.dto;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.medical_supplies.Category;
import com.example.medical_management.model.medical_supplies.Supplier;
import com.example.medical_management.model.medical_supplies.Unit;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MedicalSuppliesDto implements Validator {
    private int id;
    private String code;
    private String name;
    private long price;
    private Date importDate;
    private Date expiry;
    private int quantity;
    private Category category;
    private Supplier supplier;
    private Unit unit;
    private Account account;

    public MedicalSuppliesDto() {
    }

    public MedicalSuppliesDto(int id, String code, String name, long price, Date importDate, Date expiry, int quantity, Category category, Supplier supplier, Unit unit, Account account) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.importDate = importDate;
        this.expiry = expiry;
        this.quantity = quantity;
        this.category = category;
        this.supplier = supplier;
        this.unit = unit;
        this.account = account;
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        // Validate Mã vật tư (code)
        if (medicalDto.getCode() == null || !medicalDto.getCode().matches("^MVT-[0-9]{4}$")) {
            errors.rejectValue("code", null, "Mã vật tư phải theo định dạng MVT-XXXX");
        }
        // Validate Tên vật tư (name)
        if (medicalDto.getName() == null || medicalDto.getName().length() > 100) {
            errors.rejectValue("name", null, "Tên vật tư không được vượt quá 100 ký tự");
        }
        // Validate Giá thành (price)
        if (medicalDto.getPrice() > 0) {
            errors.rejectValue("price", null, "Giá thành phải là số nguyên dương");
        }
        // Validate Hạn sử dụng (expiry)
        try {
            Date expiryDate = sdf.parse(medicalDto.getExpiry().toString());
            Date currentDate = new Date();
            if (expiryDate.before(currentDate)) {
                errors.rejectValue("expiry", null, "Hạn sử dụng phải lớn hơn ngày hiện tại");
            }
        } catch (ParseException e) {
            errors.rejectValue("expiry", null, "Hạn sử dụng phải theo định dạng dd/MM/yy");
        }
        try {
            Date expiryDate = sdf.parse(medicalDto.getExpiry().toString());
            Date currentDate = new Date();
            if (expiryDate.before(currentDate)) {
                errors.rejectValue("expiry", null, "Hạn sử dụng phải lớn hơn ngày hiện tại");
            }
            Date importDate = sdf.parse(medicalDto.getImportDate().toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(importDate);
            calendar.add(Calendar.MONTH, 6); // Kiểm tra ít nhất 6 tháng
            Date sixMonthsLater = calendar.getTime();
            if (expiryDate.before(sixMonthsLater)) {
                errors.rejectValue("expiry", null, "Hạn sử dụng phải lớn hơn ngày nhập hàng ít nhất 6 tháng");
            }
            calendar.add(Calendar.YEAR, 1); // Kiểm tra ít nhất 1 năm
            Date oneYearLater = calendar.getTime();
            if (expiryDate.before(oneYearLater)) {
                errors.rejectValue("expiry", null, "Hạn sử dụng phải lớn hơn ngày nhập hàng ít nhất 1 năm");
            }
        } catch (ParseException e) {
            errors.rejectValue("expiry", null, "Hạn sử dụng phải theo định dạng dd/MM/yy");
        }
        // Validate Số lượng (quantity)
        if (medicalDto.getQuantity() > 0) {
            errors.rejectValue("quantity", "Số lượng phải là số nguyên dương");
        }
    }
}
