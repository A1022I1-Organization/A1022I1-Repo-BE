package com.example.medical_management.query_db.account;

public class AccountQueryDb {
    public static final String GET_ACCOUNT_ROLE_BY_USERNAME = "  SELECT * FROM account_role JOIN account \n" +
            "    ON  account_role.account_id = account.account_id \n" +
            "    JOIN app_role ON account_role.role_id = app_role.role_id     WHERE account.username = :username ;";
        public static final String GET_ACCOUNT_BY_USERNAME =  "  SELECT * FROM account WHERE account.username = :username ;";

    public static final String CHANGE_PASSWORD_ACCOUNT = "UPDATE account SET account.password = :password WHERE account.username = :username" ;
}
