package com.example.medical_management.service.account;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;

import java.util.List;

public interface IAccountService {
    void addNew(AccountRole accountRole);
    Account getAccountByUsername(String username);
    List<Account> findAllAccount();
}
