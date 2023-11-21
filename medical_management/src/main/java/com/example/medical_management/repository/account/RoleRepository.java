package com.example.medical_management.repository.account;

import com.example.medical_management.model.account.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long> {
}
