package com.enigma.interviewproject.controller;

import com.enigma.interviewproject.dto.PaymentDto;
import com.enigma.interviewproject.dto.TopUpDto;
import com.enigma.interviewproject.entity.TransactionBook;
import com.enigma.interviewproject.entity.TransactionWallet;
import com.enigma.interviewproject.service.TransactionWalletServiceDBImpl;
import com.enigma.interviewproject.service.TransactionWalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionWalletController {

    @Autowired
    TransactionWalletServiceDBImpl transactionWalletServiceDB;

    @PostMapping("/topup")
    public TransactionWallet topUpWallet(@RequestBody TopUpDto topUpDto){
        return transactionWalletServiceDB.topUp(topUpDto.getTransactionWallet(), topUpDto.getTopUpBalance());
    }

    @PostMapping("/payment")
    public TransactionBook payBook(@RequestBody PaymentDto paymentDto){
        return transactionWalletServiceDB.payment(paymentDto.getTransactionBook(), paymentDto.transactionWallet);
    }

}
