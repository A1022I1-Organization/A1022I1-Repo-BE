package com.example.medical_management.controller.rest_account_controller;

import com.example.medical_management.dto.AccountDto;
import com.example.medical_management.email.EmailService;
import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.model.account.AppRole;
import com.example.medical_management.security.payload.request.AccountRequest;
import com.example.medical_management.service.account.AccountRoleService;
import com.example.medical_management.service.account.AccountService;
import com.example.medical_management.service.account.RoleService;
import com.example.medical_management.util.account.EncrytedPasswordUtils;
import com.example.medical_management.util.password.RandomPassword;
import org.springframework.beans.BeanUtils;
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
    private AccountRoleService accountRoleService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/create-account")
    public ResponseEntity<?> create(@Valid @RequestBody AccountDto accountDto, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                String errorMessage = error.getField() + ": " + error.getDefaultMessage();
                errorMessages.add(errorMessage);
            }
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        try {

            // Mật khẩu mới
            String password = RandomPassword.generatePassword(12);
            // Mật khẩu mã hóa
            String encryptedPass = EncrytedPasswordUtils.encrytePassword(password);
            // Lưu mật khẩu mã hóa
            account.setPassword(encryptedPass);
            // Thêm mới tài khoản
            Account savedAccount = accountService.addNew(account);

            AppRole appRole = roleService.findById(accountDto.getAppRoleId());
            AccountRole accountRole = new AccountRole();
            accountRole.setAppRole(appRole);
            accountRole.setAppAccount(savedAccount);

            accountRoleService.save(accountRole);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/accountLogin")
    public ResponseEntity<Account> accountLogin(HttpServletRequest request) {
        Account account = new Account();
        return ResponseEntity.ok(account);
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody AccountRequest accountRequest) {

        String newPassword = EncrytedPasswordUtils.encrytePassword(accountRequest.getPassword());

        try {
            Boolean check = accountService.changePassword(accountRequest.getUsername(), newPassword);
            return new ResponseEntity<>(check, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/conform-password")
    public ResponseEntity<?> conformPassword(@RequestBody AccountRequest accountRequest) {

        Account account = accountService.getAccountByUsername(accountRequest.getUsername());
        Boolean check = EncrytedPasswordUtils.checkPassword(accountRequest.getPassword(), account.getPassword());
        if (check) {
            return new ResponseEntity<>(check, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

}
