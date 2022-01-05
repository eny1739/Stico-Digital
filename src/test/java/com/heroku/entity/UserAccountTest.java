package com.heroku.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountTest {

    @Test
    public void able_to_createAnUserAccount(){
        UserAccount userAccount = new UserAccount("eny","enysulistyowati1739@gmail.com", "089228339675","Surabaya","Lilo","1234567890","stitch","stitch");
        assertNotNull(userAccount);
    }

    @Test
    public void able_to_createAnUserAccount_with_given_information(){
        UserAccount expected = new UserAccount("eny","enysulistyowati1739@gmail.com", "089228339675","Surabaya","Lilo","1234567890","stitch","stitch");
        UserAccount actual = new UserAccount("eny","enysulistyowati1739@gmail.com", "089228339675","Surabaya","Lilo","1234567890","stitch","stitch");
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_true_when_createTwoUserAccounts_with_different_information(){
        UserAccount user1 = new UserAccount("eny","enysulistyowati1739@gmail.com", "089228339675","Surabaya","Lilo","1234567890","stitch","stitch");
        UserAccount user2 = new UserAccount("edwin","edwinwahyu@gmail.com", "089228339675","Surabaya","Lilo","1234567890","stitch","stitch");
        assertNotEquals(user1, user2);
    }

}
