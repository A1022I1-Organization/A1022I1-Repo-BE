package com.example.medical_management.service.account.impl;

import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.repository.account.AccountRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtAccountDetailsService implements UserDetailsService {
    @Autowired
    private AccountRoleRepository accountRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
        List<AccountRole> accountRole = accountRoleRepository.getAccountRoleByUsername(accountName);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        if (accountRole != null){
            for (AccountRole account : accountRole) {
                GrantedAuthority authority = new SimpleGrantedAuthority(account.getAppRole().getName());
                grantedAuthorities.add(authority);
            }
            return new User(accountRole.get(0).getAppAccount().getUsername(),
                    accountRole.get(0).getAppAccount().getPassword(),grantedAuthorities);
        }
        return null;

    }
}
