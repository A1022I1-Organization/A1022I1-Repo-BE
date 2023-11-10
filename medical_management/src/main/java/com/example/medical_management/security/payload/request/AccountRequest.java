package com.example.medical_management.security.payload.request;

public class AccountRequest {
    private String username;
    private String password;

    public AccountRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AccountRequest() {
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
}
