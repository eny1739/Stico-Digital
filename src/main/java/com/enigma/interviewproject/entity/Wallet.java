package com.enigma.interviewproject.entity;

import com.enigma.interviewproject.util.WalletCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

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

    public Wallet(String name, Integer balance, String userId) {
        this.name = name;
        this.balance = balance;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    public String getUserId() {
        return userId;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(name, wallet.name) && Objects.equals(balance, wallet.balance) && Objects.equals(userId, wallet.userId) && Objects.equals(userAccount, wallet.userAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance, userId, userAccount);
    }
}
