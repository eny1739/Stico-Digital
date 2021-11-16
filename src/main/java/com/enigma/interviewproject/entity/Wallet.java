package com.enigma.interviewproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "mst_wallet")
public class Wallet {

    @Id
    private String id;
    private String name;
    private Integer balance = 0;

    @Transient
    private String userId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private UserAccount userAccount;

    public Wallet() {
    }

    public Wallet(Integer balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonIgnore
    public UserAccount getUser() {
        return userAccount;
    }

    public void setUser(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
