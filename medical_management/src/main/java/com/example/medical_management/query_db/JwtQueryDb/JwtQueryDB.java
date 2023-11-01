package com.example.medical_management.query_db.JwtQueryDb;

public class JwtQueryDB {
    public static final String GET_ACCOUNT_ROLE_BY_USERNAME = "  SELECT * FROM account_role JOIN account \n" +
            "    ON  account_role.account_id = account.account_id \n" +
            "    JOIN app_role ON account_role.role_id = app_role.role_id     WHERE account.username = :username ;";
}
