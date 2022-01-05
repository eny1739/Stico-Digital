package com.heroku.service;

import com.heroku.entity.Book;
import com.heroku.entity.TransactionBook;
import com.heroku.entity.TransactionWallet;
import com.heroku.entity.Wallet;
import com.heroku.repo.TransactionBookRepository;
import com.heroku.repo.TransactionWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionServiceDBImpl {
    @Autowired
    UserAccountService userAccountService;

    @Autowired
    WalletService walletService;

    @Autowired
    BookService bookService;

    @Autowired
    TransactionWalletRepository transactionWalletRepository;

    @Autowired
    TransactionBookRepository transactionBookRepository;

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

    public TransactionBook payment(TransactionBook transactionBook, TransactionWallet transactionWallet){
        Book book = bookService.getById(transactionBook.getBook().getId());
        Integer price = book.getPrice();
        Wallet wallet = walletService.getById(transactionWallet.getWallet().getId());
        if (wallet.getBalance() > price){
            wallet.setBalance(wallet.getBalance()-price);
        } else  {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Saldo tidak mencukupi");
        }

        book.setCount(book.getCount()-transactionBook.getCount());
        bookService.update(book);
        String walletUuid = getUuid();
        String bookUuid = getUuid();
        transactionWalletRepository.createWalletTransactions(walletUuid, transactionWallet.getTransactionDate(), "payment", wallet.getName(), wallet.getId());
        transactionBookRepository.createBookTransactions(bookUuid, transactionBook.getCount(), transactionBook.getSubTotal(), transactionBook.getTransactionDate(), book.getId(), transactionBook.getUserAccount().getId());
        return transactionBookRepository.getTransactionBookById(bookUuid);
    }

    public List<TransactionBook> getAllTransactionBook(){
        return transactionBookRepository.getAllTransactionBook().stream().collect(Collectors.toList());
    }

    public List<TransactionWallet> getAllTransactionWallet(){
        return transactionWalletRepository.getAllTransactionWallet().stream().collect(Collectors.toList());
    }

    public void deleteWalletTransactionById(String id) {
        getTransactionWalletById(id);
        transactionWalletRepository.deleteWalletTransactionById(id);
    }

    public TransactionWallet getTransactionWalletById(String id) {
        TransactionWallet transactionWallet = transactionWalletRepository.getById(id);
        if (transactionWallet == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaksi tidak ditemukan");
        }
        return transactionWallet;
    }

    public void deleteBookTransactionById(String id) {
        getTransactionBookById(id);
        transactionBookRepository.deleteBookTransactionById(id);
    }

    public TransactionBook getTransactionBookById(String id) {
        TransactionBook transactionBook = transactionBookRepository.getTransactionBookById(id);
        if (transactionBook == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaksi tidak ditemukan");
        }
        return transactionBook;
    }
}
