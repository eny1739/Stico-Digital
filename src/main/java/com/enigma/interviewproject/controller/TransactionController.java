package com.enigma.interviewproject.controller;

import com.enigma.interviewproject.dto.PaymentDto;
import com.enigma.interviewproject.dto.TopUpDto;
import com.enigma.interviewproject.entity.TransactionBook;
import com.enigma.interviewproject.entity.TransactionWallet;
import com.enigma.interviewproject.service.TransactionServiceDBImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionServiceDBImpl transactionWalletServiceDB;

    @PostMapping("/topup")
    public TransactionWallet topUpWallet(@RequestBody TopUpDto topUpDto){
        return transactionWalletServiceDB.topUp(topUpDto.getTransactionWallet(), topUpDto.getTopUpBalance());
    }

    @PostMapping("/payment")
    public TransactionBook payBook(@RequestBody PaymentDto paymentDto){
        return transactionWalletServiceDB.payment(paymentDto.getTransactionBook(), paymentDto.transactionWallet);
    }

    @GetMapping("/payments")
    public List<TransactionBook> getAllTransactionBook(){
        return transactionWalletServiceDB.getAllTransactionBook();
    }

    @GetMapping("/topups")
    public List<TransactionWallet> getAllTransactionWallet(){
        return transactionWalletServiceDB.getAllTransactionWallet();
    }

    @GetMapping("/payment/{id}")
    public TransactionBook getTransactionBookById(@PathVariable(name = "id") String id){
        return transactionWalletServiceDB.getTransactionBookById(id);
    }

    @GetMapping("/topup/{id}")
    public TransactionWallet getTransactionWalletById(@PathVariable(name = "id") String id){
        return transactionWalletServiceDB.getTransactionWalletById(id);
    }

    @DeleteMapping("/payment/{id}")
    public void deleteTransactionBookById(@PathVariable(name = "id") String id){
        transactionWalletServiceDB.deleteBookTransactionById(id);
    }

    @DeleteMapping("/topup/{id}")
    public void deleteTransactionWalletById(@PathVariable(name = "id") String id){
        transactionWalletServiceDB.deleteWalletTransactionById(id);
    }

}
