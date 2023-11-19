package com.example.medical_management.controller.rest_account_controller;
import com.example.medical_management.dto.AccountRoleDto;
import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.service.account.AccountRoleService;
import com.example.medical_management.util.account.EncrytedPasswordUtils;
import com.example.medical_management.util.password.RandomPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/account")
public class RestAccountController {
    @Autowired
    private AccountRoleService accountService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody AccountRoleDto accountRoleDto, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                String errorMessage = error.getField() + ": " + error.getDefaultMessage();
                errorMessages.add(errorMessage);
            }
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        try {
            // Chuyển đổi
            Account account = convertToAccount(accountRoleDto);
            AccountRole accountRole = convertToAccountRole(accountRoleDto);

            // Mật khẩu mới
            String password = RandomPassword.generatePassword(12);
            // Mật khẩu mã hóa
            String encryptedPass = EncrytedPasswordUtils.encrytePassword(password);
            // Lưu mật khẩu mã hóa
            accountRole.getAppAccount().setPassword(encryptedPass);

            // Thêm mới tài khoản
            accountService.addNewAccount(account);
            accountService.addNew(accountRole);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    private Account convertToAccount(AccountRoleDto accountRoleDto) {
        Account account = new Account();

        // Chuyển đổi dữ liệu
        account.setEmployeeCode(accountRoleDto.getEmployeeCode());
        account.setUsername(accountRoleDto.getUsername());
        account.setPassword(accountRoleDto.getPassword());
        account.setIdCard(accountRoleDto.getIdCard());
        account.setEmployeeName(accountRoleDto.getEmployeeName());
        account.setGender(accountRoleDto.isGender());
        account.setBirthday(accountRoleDto.getBirthday());
        account.setGmail(accountRoleDto.getGmail());
        account.setPhone(accountRoleDto.getPhone());
        account.setAddress(accountRoleDto.getAddress());
        account.setImgLink(accountRoleDto.getImgLink());

        return account;
    }

    private AccountRole convertToAccountRole(AccountRoleDto accountRoleDto) {
        AccountRole accountRole = new AccountRole();

        // Chuyển đổi dữ liệu
        accountRole.setAppAccount(convertToAccount(accountRoleDto));
        accountRole.setAppRole(accountService.findRoleById(accountRoleDto.getRoleId()));

        return accountRole;
    }


    @GetMapping("/accountLogin")
    public ResponseEntity<Account> accountLogin(HttpServletRequest request) {

        Account account = new Account();

        return ResponseEntity.ok(account);
    }


}
