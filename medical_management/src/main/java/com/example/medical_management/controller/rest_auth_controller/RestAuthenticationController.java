package com.example.medical_management.controller.rest_auth_controller;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.security.JwtUtil;
import com.example.medical_management.security.payload.request.JwtRequest;
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

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class RestAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping(value = "/login")
    public ResponseEntity<?> loginByAccount(@RequestBody JwtRequest response) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(response.getUsername(), response.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtil.generateJwtToken(response.getUsername());
        System.out.println(jwt);
        return ResponseEntity.ok(jwt);
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


    @GetMapping(value = "/test")
    public ResponseEntity<?> test() throws Exception {

        return ResponseEntity.ok("Okkk");
    }

}
