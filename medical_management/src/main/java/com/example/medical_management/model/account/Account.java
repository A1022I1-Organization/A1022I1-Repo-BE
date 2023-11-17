package com.example.medical_management.model.account;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;
    private String employeeCode;
    private String username;
    private String password;
    private String idCard;
    private String employeeName;
    private Boolean gender;
    private Date birthday;
    private String gmail;
    private String phone;
    private String address;
    private String imgLink;

    public Account() {
    }

    public Account(Long id, String username, String password, String idCard, String employeeName, String employeeCode, Boolean gender,
                   Date birthday, String gmail, String phone, String address,
                   String imgLink) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.idCard = idCard;
        this.employeeName = employeeName;
        this.employeeCode = employeeCode;
        this.gender = gender;
        this.birthday = birthday;
        this.gmail = gmail;
        this.phone = phone;
        this.address = address;
        this.imgLink = imgLink;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String accountName) {
        this.username = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String accountPassword) {
        this.password = accountPassword;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String numberPhone) {
        this.phone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
