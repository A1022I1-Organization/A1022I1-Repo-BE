package com.example.medical_management.service.account;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.model.account.AppRole;

public interface AccountRoleService {
    void addNew(AccountRole accountRole);

    AppRole findRoleById(Long id);

    void addNewAccount(Account account);
}
