package com.example.medical_management.dto;

import com.example.medical_management.model.account.AccountRole;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AccountRoleDto implements Validator {
    private String employeeCode;
    private String username;
    private String password;
    private String idCard;
    private String employeeName;
    private boolean gender;
    private Date birthday;
    private String gmail;
    private String phone;
    private String address;
    private String imgLink;
    private Long roleId;

    public AccountRoleDto() {
    }

    public AccountRoleDto(String employeeCode, String username, String password, String idCard, String employeeName, boolean gender, Date birthday, String gmail, String phone, String address, String imgLink, Long roleId) {
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
        this.roleId = roleId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountRoleDto accountRoleDto = (AccountRoleDto) target;

        // TÊN TÀI KHOẢN
        if (accountRoleDto.getUsername() == null) {
            errors.rejectValue("username", null, "Tên tài khoản không được rỗng");
        }

        // MÃ NHÂN VIÊN
        if (accountRoleDto.getEmployeeCode() == null) {
            errors.rejectValue("employeeCode", null, "Mã nhân viên không được rỗng");
        }

        // CCCD/CMND
        if (accountRoleDto.getIdCard() == null) {
            errors.rejectValue("idCard", null, "CCCD/CMND không được rỗng");
        } else if (!accountRoleDto.getIdCard().matches("^\\d{9,12}$")) {
            errors.rejectValue("idCard", null, "CCCD/CMND không đúng định dạng");
        }

        // TÊN NHÂN VIÊN
        if (accountRoleDto.getEmployeeName() == null) {
            errors.rejectValue("employeeName", null, "Tên nhân viên không được rỗng");
        }

        // NGÀY SINH
        if (accountRoleDto.getBirthday() == null) {
            errors.rejectValue("birthday", null, "Ngày sinh không được rỗng");
        } else {
            Date currentDate = new Date();
            Date birthday = accountRoleDto.getBirthday();

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
        if (accountRoleDto.getGmail() == null) {
            errors.rejectValue("gmail", null, "Gmail không được rỗng");
        } else if (!accountRoleDto.getGmail().matches("^[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*@gmail\\.com$")) {
            errors.rejectValue("gmail", null, "Gmail không đúng định dạng");
        }

        // SỐ ĐIỆN THOẠI
        if (accountRoleDto.getPhone() == null) {
            errors.rejectValue("phone", null, "Số điện thoại không được rỗng");
        } else if (!accountRoleDto.getPhone().matches(" ")) {
            errors.rejectValue("phone", null, "Số điện thoại không đúng định dạng");
        }

        // ĐỊA CHỈ
        if (accountRoleDto.getAddress() == null) {
            errors.rejectValue("address", null, "Địa chỉ không được rỗng");
        }

        // Ảnh
        if (accountRoleDto.getImgLink() == null) {
            errors.rejectValue("imgLink", null, "Ảnh không được để trống");
        }
    }
}
