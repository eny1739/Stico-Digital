package com.enigma.interviewproject.dto;

import java.util.List;

public class TransactionBookDto {
    private String userAccountId;
    private List<BookTransactionDto> books;

    public TransactionBookDto() {
    }

    public String getUserAccountId() {
        return userAccountId;
    }

    public List<BookTransactionDto> getBooks() {
        return books;
    }
}
