package com.example.medical_management.service.account;

import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void addNew(AccountRole accountRole) {
        accountRepository.save(accountRole);
    }
}
