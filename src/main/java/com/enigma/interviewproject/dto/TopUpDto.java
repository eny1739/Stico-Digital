package com.enigma.interviewproject.dto;

import com.enigma.interviewproject.entity.TransactionWallet;

public class TopUpDto {
    public TransactionWallet transactionWallet;
    public Integer topUpBalance;

    public TopUpDto(TransactionWallet transactionWallet, Integer topUpBalance) {
        this.transactionWallet = transactionWallet;
        this.topUpBalance = topUpBalance;
    }

    public TransactionWallet getTransactionWallet() {
        return transactionWallet;
    }

    public Integer getTopUpBalance() {
        return topUpBalance;
    }
}
