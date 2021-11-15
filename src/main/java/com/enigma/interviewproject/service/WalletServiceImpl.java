package com.enigma.interviewproject.service;

import com.enigma.interviewproject.entity.Wallet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService{
    @Override
    public void create(Wallet wallet) {
    }

    @Override
    public List<Wallet> findAll() {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Wallet getById(String id) {
        return null;
    }

//    @Override
    public void update(Wallet wallet) {
    }
}
