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

    @GetMapping("/books")
    public List<Book> findAllBooks(){
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public Book getById(@PathVariable(name = "id") String id) {
        return bookService.getById(id);
    }

    @PostMapping("/book")
    public Book createBook(@RequestBody Book book){
       return bookService.create(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteById(@PathVariable(name = "id") String id){
        bookService.deleteById(id);
    }

    @PutMapping("/book")
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }
}
