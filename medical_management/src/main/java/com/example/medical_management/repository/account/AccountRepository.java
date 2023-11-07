package com.example.medical_management.repository.account;

import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.query_db.account.AccountQueryDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = AccountQueryDb.GET_ACCOUNT_BY_USERNAME, nativeQuery = true)
    Account getAccountByUsername(@Param("username") String username);
}
