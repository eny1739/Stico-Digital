package com.enigma.interviewproject.entity;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    @Test
    public void able_to_createAWallet(){
        Wallet wallet = new Wallet("DONO", 2000, "yqwiur23yfo2ucu");
        assertNotNull(wallet);
    }

    @Test
    public void able_to_createAWallet_with_given_information(){
        Wallet expected = new Wallet("DONO", 2000, "yqwiur23yfo2ucu");
        Wallet actual = new Wallet("DONO", 2000, "yqwiur23yfo2ucu");
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_true_when_createTwoWallets_with_different_information(){
        Wallet wallet1 = new Wallet("DONO", 2000, "yqwiur23yfo2ucu");
        Wallet wallet2 = new Wallet("GAPAY", 25000, "hefiuyu2pwujcs83u");
        assertNotEquals(wallet1, wallet2);
    }

}