package com.example.medical_management.service.account;

import com.example.medical_management.model.account.AppRole;


public interface RoleService {
    AppRole findById(Long id);
}
