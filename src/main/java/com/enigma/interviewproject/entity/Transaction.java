package com.enigma.interviewproject.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tx_user_do_transactions")
public class Transaction {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private Integer count;
    private Integer subTotal;
    private Date transactionDate;

    public Transaction(UserAccount userAccount, Book book, Integer count, Integer subTotal, Date transactionDate) {
        this.userAccount = userAccount;
        this.book = book;
        this.count = count;
        this.subTotal = subTotal;
        this.transactionDate = transactionDate;
    }

    public Transaction() {
    }

    public String getId() {
        return id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Book getBook() {
        return book;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getSubTotal() {
        return subTotal;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
