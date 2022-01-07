package com.heroku.controller;

import com.heroku.entity.Book;
import com.heroku.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> findAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/api/book/{id}")
    public Book getById(@PathVariable(name = "id") String id) {
        return bookService.getById(id);
    }

    @PostMapping("/api/book")
    public Book createBook(@RequestBody Book book){
       return bookService.create(book);
    }

    @DeleteMapping("/api/book/{id}")
    public void deleteById(@PathVariable(name = "id") String id){
        bookService.deleteById(id);
    }

    @PutMapping("/api/book")
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }
}
