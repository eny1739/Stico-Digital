package com.enigma.interviewproject.dto;

public class BookTransactionDto {

    private String bookId;
    private Integer count;
    private String status;

    public BookTransactionDto() {
    }

    public String getBookId() {
        return bookId;
    }

    public Integer getCount() {
        return count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
