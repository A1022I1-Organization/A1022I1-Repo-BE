package com.example.medical_management.model.medical_supplies;

import com.example.medical_management.model.account.Account;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class MedicalSupplies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_supplies_id")
    private Long id;
    @Column(columnDefinition = "longtext")
    private String picture;
    private String code;
    private String name;
    private float price;
    @Column(columnDefinition = "DATE")
    private Date importDate;
    @Column(columnDefinition = "DATE")
    private Date expiry;
    private String quantity;
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

    @Column(name = "delete_flag", columnDefinition = "Boolean default FALSE")
    private boolean deleteFlag;

    public MedicalSupplies() {
    }

    public MedicalSupplies(Long id, String picture, String code, String name, float price, Date importDate, Date expiry, String quantity, Category category, Supplier supplier, Unit unit, Account account, boolean deleteFlag) {
        this.id = id;
        this.picture = picture;
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
        this.deleteFlag = deleteFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long supplyId) {
        this.id = supplyId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}