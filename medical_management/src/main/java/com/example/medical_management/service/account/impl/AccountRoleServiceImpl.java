package com.example.medical_management.service.account.impl;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.model.account.AppRole;
import com.example.medical_management.repository.account.AccountRepository;
import com.example.medical_management.repository.account.AccountRoleRepository;
import com.example.medical_management.repository.account.RoleRepository;
import com.example.medical_management.service.account.AccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountRoleServiceImpl implements AccountRoleService {
    @Autowired
    private AccountRoleRepository accountRoleRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void addNew(AccountRole accountRole) {
        accountRoleRepository.save(accountRole);
    }

    @Override
    public AppRole findRoleById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public void save(AccountRole accountRole) {
        accountRoleRepository.save(accountRole);
    }

    @Override
    public List<AccountRole> getAccountRoleByUsername(String username) {
        return accountRoleRepository.getAccountRoleByUsername(username);
    }
}
