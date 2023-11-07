package com.example.medical_management.security.payload.response;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;

public class JWTResponse {
    private String token;
    private AccountRole accountRole;

    public JWTResponse(String token, AccountRole accountRole) {
        this.token = token;
        this.accountRole = accountRole;
    }

    public JWTResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AccountRole getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(AccountRole accountRole) {
        this.accountRole = accountRole;
    }
}
