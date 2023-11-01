package com.example.medical_management.model.medical_supplies;

import com.example.medical_management.model.account.Account;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MedicalSupplies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_supplies_id")
    private int id;
    private String code;
    private String name;
    private long price;
    private Date importDate;
    private String expiry;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "supplier_id",referencedColumnName = "supplier_id")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "unit_id",referencedColumnName = "unit_id")
    private Unit unit;
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    private Account account;

    public MedicalSupplies() {
    }

    public MedicalSupplies(int id, String code, String name, long price, Date importDate, String expiry, Category category, Supplier supplier, Unit unit, Account account) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.importDate = importDate;
        this.expiry = expiry;
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

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
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
}
