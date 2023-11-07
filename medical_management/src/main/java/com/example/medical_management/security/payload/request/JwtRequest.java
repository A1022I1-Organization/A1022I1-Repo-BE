package com.example.medical_management.security.payload.request;

public class JwtRequest {
    private String token;

    public JwtRequest(String token) {
        this.token = token;
    }

    public JwtRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
