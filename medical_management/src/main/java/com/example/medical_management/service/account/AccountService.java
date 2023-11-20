package com.example.medical_management.service.account;

import com.example.medical_management.model.account.Account;

import java.util.List;

public interface AccountService {
    Account addNew(Account account);
    Account getAccountByUsername(String username);
    List<Account> findAllAccount();
    Boolean changePassword(String username,String password);
}
