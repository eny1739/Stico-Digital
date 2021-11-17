package com.enigma.interviewproject.service;

import com.enigma.interviewproject.entity.UserAccount;
import com.enigma.interviewproject.entity.Wallet;
import com.enigma.interviewproject.repo.WalletRepository;
import com.enigma.interviewproject.util.WalletCategory;
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
public class WalletServiceImpl implements WalletService{

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    UserAccountService userAccountService;

    private void walletTypeValidation(Wallet wallet) {
        if(!(wallet.getName().equals("AVA") || wallet.getName().equals("DONO") || wallet.getName().equals("GAPAY"))){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Jenis wallet tidak ada");
        }
    }

    @Override
    public Wallet create(Wallet wallet) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        while (walletRepository.getById(uuid) != null){
            uuid = UUID.randomUUID().toString().replaceAll("-","");
        }
        UserAccount userAccount = userAccountService.getById(wallet.getUserId());
        wallet.setUserAccount(userAccount);
        walletTypeValidation(wallet);
        walletRepository.createWallet(uuid, wallet.getName(), wallet.getBalance(), wallet.getUserAccount().getId());
        return getById(uuid);
    }

    @Override
    public List<Wallet> findAll() {
        return walletRepository.getAllWallet().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        getById(id);
        walletRepository.deleteById(id);
    }

    @Override
    public Wallet getById(String id) {
        Wallet wallet = walletRepository.getById(id);
        if (wallet == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Wallet tidak ditemukan");
        }
        return wallet;
    }

    @Override
    public Wallet update(Wallet wallet) {
        getById(wallet.getId());
        walletTypeValidation(wallet);
        walletRepository.updateWallet(wallet.getName(), wallet.getBalance(), wallet.getUserId(), wallet.getId());
        return wallet;
    }
}
