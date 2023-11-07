package com.example.medical_management.controller.rest_auth_controller;

import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.security.JwtUtil;
import com.example.medical_management.security.payload.request.AccountRequest;
import com.example.medical_management.security.payload.request.JwtRequest;
import com.example.medical_management.security.payload.response.JWTResponse;
import com.example.medical_management.service.account.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AccountRoleService accountRoleService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginByAccount(@RequestBody AccountRequest response) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(response.getUsername(), response.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtil.generateJwtToken(response.getUsername());
        List<AccountRole> accountRole = accountRoleService.getAccountRoleByUsername(response.getUsername());
        AccountRole  account  = new AccountRole();
        for (AccountRole accountRole1: accountRole) {
            account.setAppAccount(accountRole1.getAppAccount());
            account.setAppRole(accountRole1.getAppRole());
        }
        JWTResponse jwtResponse = new JWTResponse(jwt,account);
        return ResponseEntity.ok(jwtResponse);
    }
    @GetMapping(value = "/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/user")
    public Principal user(Principal principal) {
//        System.out.println("username : " + principal.getName());
        return principal;
    }
    @PostMapping("/getAccount")
    public ResponseEntity<?> getAccount(@RequestBody JwtRequest jwt) {
        String username = jwtUtil.getUserNameFromJwtToken(jwt.getToken());

        List<AccountRole> accountRole = accountRoleService.getAccountRoleByUsername(username);
        AccountRole  account  = new AccountRole();
        for (AccountRole accountRole1: accountRole) {
            account.setAppAccount(accountRole1.getAppAccount());
            account.setAppRole(accountRole1.getAppRole());
        }
        return ResponseEntity.ok(account);
    }


    @GetMapping(value = "/checkAuthen")
    public ResponseEntity<?> test() throws Exception {
        System.out.println("ok");
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
