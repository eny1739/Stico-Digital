package com.enigma.interviewproject.dto;

import com.enigma.interviewproject.entity.TransactionBook;
import com.enigma.interviewproject.entity.TransactionWallet;

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
