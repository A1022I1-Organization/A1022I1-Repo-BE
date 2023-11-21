package com.example.medical_management.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AccountDto implements Validator {
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
    private Long appRoleId;

    public AccountDto() {
    }

    public AccountDto(Long id, String username, String password, String idCard, String employeeName, String employeeCode, Boolean gender,
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

    public AccountDto(Long id, String employeeCode, String username, String password, String idCard, String employeeName, Boolean gender, Date birthday, String gmail, String phone, String address, String imgLink, Long appRoleId) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.username = username;
        this.password = password;
        this.idCard = idCard;
        this.employeeName = employeeName;
        this.gender = gender;
        this.birthday = birthday;
        this.gmail = gmail;
        this.phone = phone;
        this.address = address;
        this.imgLink = imgLink;
        this.appRoleId = appRoleId;
    }

    public Boolean getGender() {
        return gender;
    }

    public Long getAppRoleId() {
        return appRoleId;
    }

    public void setAppRoleId(Long appRoleId) {
        this.appRoleId = appRoleId;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDto accountDto = (AccountDto) target;

        // TÊN TÀI KHOẢN
        if (accountDto.getUsername() == null) {
            errors.rejectValue("username", null, "Tên tài khoản không được rỗng");
        }

        // MÃ NHÂN VIÊN
        if (accountDto.getEmployeeCode() == null) {
            errors.rejectValue("employeeCode", null, "Mã nhân viên không được rỗng");
        }

        // CCCD/CMND
        if (accountDto.getIdCard() == null) {
            errors.rejectValue("idCard", null, "CCCD/CMND không được rỗng");
        } else if (!accountDto.getIdCard().matches("^\\d{9,12}$")) {
            errors.rejectValue("idCard", null, "CCCD/CMND không đúng định dạng");
        }

        // TÊN NHÂN VIÊN
        if (accountDto.getEmployeeName() == null) {
            errors.rejectValue("employeeName", null, "Tên nhân viên không được rỗng");
        }

        // NGÀY SINH
        if (accountDto.getBirthday() == null) {
            errors.rejectValue("birthday", null, "Ngày sinh không được rỗng");
        } else {
            Date currentDate = new Date();
            Date birthday = accountDto.getBirthday();

            // Tính toán tuổi
            Calendar currentCalendar = new GregorianCalendar();
            currentCalendar.setTime(currentDate);

            Calendar birthCalendar = new GregorianCalendar();
            birthCalendar.setTime(birthday);

            int age = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);

            // Kiểm tra tuổi
            if (age < 18 || age >= 65) {
                errors.rejectValue("birthday", null, "Tuổi nhân viên phải lớn hơn 18 và nhỏ hơn 65");
            }
        }

        // EMAIL
        if (accountDto.getGmail() == null) {
            errors.rejectValue("gmail", null, "Gmail không được rỗng");
        } else if (!accountDto.getGmail().matches("^[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*@gmail\\.com$")) {
            errors.rejectValue("gmail", null, "Gmail không đúng định dạng");
        }

        // SỐ ĐIỆN THOẠI
        if (accountDto.getPhone() == null) {
            errors.rejectValue("phone", null, "Số điện thoại không được rỗng");
        } else if (!accountDto.getPhone().matches(" ")) {
            errors.rejectValue("phone", null, "Số điện thoại không đúng định dạng");
        }

        // ĐỊA CHỈ
        if (accountDto.getAddress() == null) {
            errors.rejectValue("address", null, "Địa chỉ không được rỗng");
        }

        // Ảnh
        if (accountDto.getImgLink() == null) {
            errors.rejectValue("imgLink", null, "Ảnh không được để trống");
        }
    }
}
