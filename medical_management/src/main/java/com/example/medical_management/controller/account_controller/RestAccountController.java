package com.example.medical_management.controller.account_controller;

import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.service.account.AccountService;
import com.example.medical_management.service.email.EmailService;
import com.example.medical_management.util.account.EncrytedPasswordUtils;
import com.example.medical_management.util.password.RandomPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class RestAccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private EmailService emailService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody AccountRole accountRole) {
        try {
            accountService.addNew(accountRole);
            accountRole.getAppAccount().setPassword(RandomPassword.generatePassword(12));
            emailService.sendSimpleMessage(
                    accountRole.getAppAccount().getGmail(),
                    "Mật khẩu tài khoản vật tư y tế",
                    "Mật khẩu mới của bạn: " + accountRole.getAppAccount().getPassword()
            );
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
