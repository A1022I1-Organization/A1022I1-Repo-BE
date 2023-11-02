package com.example.medical_management.model.account;

import javax.persistence.*;

@Entity
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    private AppRole appRole;
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "account_id")
    private Account account;

    public AccountRole() {
    }

    public AccountRole(Long id, AppRole appRole, Account account) {
        this.id = id;
        this.appRole = appRole;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public Account getAppAccount() {
        return account;
    }

    public void setAppAccount(Account account) {
        this.account = account;
    }
}
