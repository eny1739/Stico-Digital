package com.enigma.interviewproject.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "mst_wallet")
public class Wallet {

    @Id
    private String id;
    private Integer balance = 0;

    @Transient
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
