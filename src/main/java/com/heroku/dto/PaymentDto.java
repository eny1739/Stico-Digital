package com.heroku.dto;

import com.heroku.entity.TransactionBook;
import com.heroku.entity.TransactionWallet;

public class PaymentDto {
    public TransactionBook transactionBook;
    public TransactionWallet transactionWallet;

    public PaymentDto(TransactionBook transactionBook, TransactionWallet transactionWallet) {
        this.transactionBook = transactionBook;
        this.transactionWallet = transactionWallet;
    }

    public TransactionBook getTransactionBook() {
        return transactionBook;
    }

    public TransactionWallet getTransactionWallet() {
        return transactionWallet;
    }
}
