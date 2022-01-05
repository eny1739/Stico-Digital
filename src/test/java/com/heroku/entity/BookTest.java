package com.heroku.entity;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void able_to_createAccount(){
        Book book = new Book("Bobo", "Gramedia", Date.valueOf("2020-09-10"), 20000, "MAGAZINE", 10);
        assertNotNull(book);
    }

    @Test
    public void able_to_createABook_with_given_information(){
        Book expected = new Book("Bobo", "Gramedia", Date.valueOf("2020-09-10"), 20000, "MAGAZINE", 10);
        Book actual = new Book("Bobo", "Gramedia", Date.valueOf("2020-09-10"), 20000, "MAGAZINE", 10);
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_true_when_createTwoBooks_with_different_information(){
        Book book1 = new Book("Bobo", "Gramedia", Date.valueOf("2020-09-10"), 20000, "MAGAZINE", 10);
        Book book2 = new Book("Lilo stitch", "Gramedia", Date.valueOf("2020-09-10"), 20000, "MAGAZINE", 10);
        assertNotEquals(book1, book2);
    }

}
