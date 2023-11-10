package com.example.medical_management.service.account;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.model.account.AppRole;

import java.util.List;

public interface AccountRoleService {
    void addNew(AccountRole accountRole);

    AppRole findRoleById(Long id);

    void addNewAccount(Account account);

    List<AccountRole> getAccountRoleByUsername(String username);

}
