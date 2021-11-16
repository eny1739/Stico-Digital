package com.enigma.interviewproject.service;

import com.enigma.interviewproject.entity.TransactionWallet;
import com.enigma.interviewproject.entity.Wallet;
import com.enigma.interviewproject.repo.TransactionWalletRepository;
import com.enigma.interviewproject.util.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TransactionWalletServiceDBImpl {
    @Autowired
    UserAccountService userAccountService;

    @Autowired
    WalletService walletService;

    @Autowired
    TransactionWalletRepository transactionWalletRepository;

    private String getUuid() {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        while (transactionWalletRepository.findById(uuid).isPresent()){
            uuid = UUID.randomUUID().toString().replaceAll("-","");
        }
        return uuid;
    }

    public TransactionWallet topUp(TransactionWallet transactionWallet, Integer topUpBalance){
        Wallet wallet = walletService.getById(transactionWallet.getWallet().getId());
        wallet.setBalance(wallet.getBalance()+topUpBalance);
        walletService.update(wallet);
        String uuid = getUuid();
        transactionWalletRepository.createWalletTransactions(uuid, transactionWallet.getTransactionDate(), "top-up", wallet.getName(), wallet.getId());
        return transactionWalletRepository.getById(uuid);
    }


//    @Override
//    public List<TransactionWallet> findAll() {
//        return null;
//    }
//
//    @Override
//    public void deleteById(String id) {
//
//    }
//
//    @Override
//    public TransactionWallet getById(String id) {
//        return null;
//    }

//    @Override
//    public TransactionWallet update(TransactionWallet transactionWallet) {
//        return null;
//    }
}
