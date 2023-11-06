package com.example.medical_management.service.account;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.model.account.AppRole;
import com.example.medical_management.repository.account.AccountRepository;
import com.example.medical_management.repository.account.AccountRoleRepository;
import com.example.medical_management.repository.account.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    private AccountRoleRepository accountRoleRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public void addNew(AccountRole accountRole) {
        accountRoleRepository.save(accountRole);
    }

    @Override
    public AppRole findRoleById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public void addNewAccount(Account account) {
        accountRepository.save(account);
    }
}
