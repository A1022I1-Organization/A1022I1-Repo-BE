package com.example.medical_management.controller.rest_account_controller;

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
        return ResponseEntity.ok(jwt);
    }

    @GetMapping
    public String welcome() {
        return "Welcome to Google !!";
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        System.out.println("username : " + principal.getName());
        return principal;
    }


    @GetMapping(value = "/test")
    public ResponseEntity<?> test() throws Exception {

        return ResponseEntity.ok("Okkk");
    }
    
}
