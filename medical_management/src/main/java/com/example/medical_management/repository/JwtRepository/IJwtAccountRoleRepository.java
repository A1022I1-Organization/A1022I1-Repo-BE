package com.example.medical_management.repository.JwtRepository;

import com.example.medical_management.query_db.JwtQueryDb.JwtQueryDB;
import com.example.medical_management.model.account.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJwtAccountRoleRepository extends JpaRepository<AccountRole,Long> {
    @Query(value = JwtQueryDB.GET_ACCOUNT_ROLE_BY_USERNAME, nativeQuery = true)
    List<AccountRole> getAccountRoleByUsername(@Param("username") String username);
}
