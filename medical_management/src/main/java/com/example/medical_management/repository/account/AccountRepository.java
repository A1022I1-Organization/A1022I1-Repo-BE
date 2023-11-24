package com.example.medical_management.repository.account;

import com.example.medical_management.dto.AccountDto;
import com.example.medical_management.model.account.Account;
import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.query_db.account.AccountQueryDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = AccountQueryDb.GET_ACCOUNT_BY_USERNAME, nativeQuery = true)
    Account getAccountByUsername(@Param("username") String username);

    @Modifying
    @Query(value = AccountQueryDb.CHANGE_PASSWORD_ACCOUNT, nativeQuery = true)
    @Transactional
    void changePassword(@Param("username") String username,@Param("password") String password);



//    @Query(value = AccountQueryDb.CREATE_NEW_ACCOUNT, nativeQuery = true)
//    void createNewAccount(@Param("account") Account account);
}
