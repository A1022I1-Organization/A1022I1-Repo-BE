package com.example.medical_management.service.account.imlp;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.repository.account.AccountRepository;
import com.example.medical_management.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImlp implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public void addNew(AccountRole accountRole) {

    }


    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.getAccountByUsername( username);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAll();
    }
}
