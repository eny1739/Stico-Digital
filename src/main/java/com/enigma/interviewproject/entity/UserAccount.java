package com.enigma.interviewproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="mst_user")
public class UserAccount {

    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String motherName;
    private String accountNumber;
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userAccount", cascade = CascadeType.MERGE)
    private List<Wallet> wallets;

    public UserAccount() {
    }

    public UserAccount(String name, String email, String phoneNumber, String address, String motherName, String accountNumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.motherName = motherName;
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }

    @JsonIgnore
    public List<Wallet> getWallets() {
        return wallets;
    }

    public void addWallet(List<Wallet> wallets){
        this.wallets.addAll(wallets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount userAccount = (UserAccount) o;
        return Objects.equals(id, userAccount.id) && Objects.equals(name, userAccount.name) && Objects.equals(email, userAccount.email) && Objects.equals(phoneNumber, userAccount.phoneNumber) && Objects.equals(address, userAccount.address) && Objects.equals(motherName, userAccount.motherName) && Objects.equals(accountNumber, userAccount.accountNumber) && Objects.equals(username, userAccount.username) && Objects.equals(password, userAccount.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phoneNumber, address, motherName, accountNumber, username, password);
    }
}
