package com.enigma.interviewproject.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "mst_book")
public class Book {

    @Id
    private String id;
    private String title;
    private String publisher;
    private Date year;
    private Integer price;
    private String category;
    private Integer count;

    public Book() {
    }

    public Book(String title, String publisher, Date year, Integer price, String category, Integer count) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
        this.category = category;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getYear() {
        return year;
    }

    public Integer getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Integer getCount() {
        return count;
    }
}
