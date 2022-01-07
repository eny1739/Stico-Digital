package com.heroku.controller;

import com.heroku.dto.PaymentDto;
import com.heroku.dto.TopUpDto;
import com.heroku.entity.TransactionBook;
import com.heroku.entity.TransactionWallet;
import com.heroku.service.TransactionServiceDBImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionServiceDBImpl transactionWalletServiceDB;

    @PostMapping("/api/topup")
    public TransactionWallet topUpWallet(@RequestBody TopUpDto topUpDto){
        return transactionWalletServiceDB.topUp(topUpDto.getTransactionWallet(), topUpDto.getTopUpBalance());
    }

    @PostMapping("/api/payment")
    public TransactionBook payBook(@RequestBody PaymentDto paymentDto){
        return transactionWalletServiceDB.payment(paymentDto.getTransactionBook(), paymentDto.transactionWallet);
    }

    @GetMapping("/api/payments")
    public List<TransactionBook> getAllTransactionBook(){
        return transactionWalletServiceDB.getAllTransactionBook();
    }

    @GetMapping("/api/topups")
    public List<TransactionWallet> getAllTransactionWallet(){
        return transactionWalletServiceDB.getAllTransactionWallet();
    }

    @GetMapping("/api/payment/{id}")
    public TransactionBook getTransactionBookById(@PathVariable(name = "id") String id){
        return transactionWalletServiceDB.getTransactionBookById(id);
    }

    @GetMapping("/api/topup/{id}")
    public TransactionWallet getTransactionWalletById(@PathVariable(name = "id") String id){
        return transactionWalletServiceDB.getTransactionWalletById(id);
    }

    @DeleteMapping("/api/payment/{id}")
    public void deleteTransactionBookById(@PathVariable(name = "id") String id){
        transactionWalletServiceDB.deleteBookTransactionById(id);
    }

    @DeleteMapping("/api/topup/{id}")
    public void deleteTransactionWalletById(@PathVariable(name = "id") String id){
        transactionWalletServiceDB.deleteWalletTransactionById(id);
    }

}
