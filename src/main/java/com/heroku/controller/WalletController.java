package com.heroku.controller;

import com.heroku.entity.Wallet;
import com.heroku.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping("/api/wallet")
    public Wallet createWallet(@RequestBody Wallet wallet){
        return walletService.create(wallet);
    }

    @GetMapping("/api/wallets")
    public List<Wallet> findAllWallets(){return  walletService.findAll();}

    @GetMapping("/api/wallet/{id}")
    public Wallet getById(@PathVariable(name = "id") String id){return walletService.getById(id);}

    @DeleteMapping("/api/wallet/{id}")
    public void deleteById(@PathVariable(name = "id") String id){walletService.deleteById(id);}

    @PutMapping("/api/wallet")
    public Wallet updateWallet(@RequestBody Wallet wallet){return walletService.update(wallet);}
}
