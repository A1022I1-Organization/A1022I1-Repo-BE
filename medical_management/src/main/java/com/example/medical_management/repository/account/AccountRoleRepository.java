package com.example.medical_management.repository.account;

import com.example.medical_management.model.account.AccountRole;
import com.example.medical_management.query_db.account.AccountQueryDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
    @Query(value = AccountQueryDb.GET_ACCOUNT_ROLE_BY_USERNAME, nativeQuery = true)
    List<AccountRole> getAccountRoleByUsername(@Param("username") String username);

//    @Query(value = AccountQueryDb.CREATE_NEW_ACCOUNT_ROLE, nativeQuery = true)
//    void createNewAccountRole(@Param("accountId") Long accountId, @Param("appRoleId") Long appRoleId);
}
