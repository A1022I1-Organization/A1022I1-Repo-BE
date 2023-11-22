package com.example.medical_management.service.account.impl;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.repository.account.AccountRepository;
import com.example.medical_management.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Account addNew(Account account) {
        return accountRepository.save(account);
    }
    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.getAccountByUsername( username);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Boolean changePassword(String username, String password) {
        try{
            accountRepository.changePassword(username,password);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;

        }
    }
}
