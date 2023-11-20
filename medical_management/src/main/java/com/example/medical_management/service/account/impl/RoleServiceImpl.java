package com.example.medical_management.service.account.impl;

import com.example.medical_management.model.account.AppRole;
import com.example.medical_management.repository.account.RoleRepository;
import com.example.medical_management.service.account.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppRole findById(Long id) {
        return roleRepository.findById(id).get();
    }
}
