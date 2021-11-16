package com.enigma.interviewproject.entity;

import com.enigma.interviewproject.util.TransactionType;
import com.enigma.interviewproject.util.WalletCategory;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tx_wallet_transaction")
public class TransactionWallet {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    private String walletCategory;
    private Date transactionDate;
    private String type;

    public TransactionWallet() {
    }

    public TransactionWallet(Wallet wallet, String walletCategory, Date transactionDate, String type) {
        this.wallet = wallet;
        this.walletCategory = walletCategory;
        this.transactionDate = transactionDate;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getWalletCategory() {
        return walletCategory;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }


    public String getType() {
        return type;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Date setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
        return transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionWallet that = (TransactionWallet) o;
        return Objects.equals(id, that.id) && Objects.equals(wallet, that.wallet) && Objects.equals(walletCategory, that.walletCategory) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wallet, walletCategory, transactionDate, type);
    }
}
