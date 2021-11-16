package com.enigma.interviewproject.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(publisher, book.publisher) && Objects.equals(year, book.year) && Objects.equals(price, book.price) && Objects.equals(category, book.category) && Objects.equals(count, book.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, publisher, year, price, category, count);
    }
}
