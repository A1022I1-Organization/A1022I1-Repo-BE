package com.example.medical_management.service.account;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;

public interface IAccountService {
    void addNew(AccountRole accountRole);
    Account getAccountByUsername(String username);
}
