package com.enigma.interviewproject.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tx_user_buy_books")
public class TransactionBook {

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

    public TransactionBook(UserAccount userAccount, Book book, Integer count, Integer subTotal, Date transactionDate) {
        this.userAccount = userAccount;
        this.book = book;
        this.count = count;
        this.subTotal = subTotal;
        this.transactionDate = transactionDate;
    }

    public TransactionBook() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionBook that = (TransactionBook) o;
        return Objects.equals(id, that.id) && Objects.equals(userAccount, that.userAccount) && Objects.equals(book, that.book) && Objects.equals(count, that.count) && Objects.equals(subTotal, that.subTotal) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userAccount, book, count, subTotal, transactionDate);
    }
}
