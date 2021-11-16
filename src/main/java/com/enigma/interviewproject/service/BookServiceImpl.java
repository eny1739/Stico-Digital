package com.enigma.interviewproject.service;

import com.enigma.interviewproject.entity.Book;
import com.enigma.interviewproject.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        while (bookRepository.findById(uuid).isPresent()){
            uuid = UUID.randomUUID().toString().replaceAll("-","");
        }
        bookRepository.createBook(uuid, book.getTitle(), book.getPublisher(), book.getYear(), book.getPrice(), book.getCategory(), book.getCount());
        return getById(uuid);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.getAllBook();
    }

    @Override
    public void deleteById(String id) {
        getById(id);
        bookRepository.deleteById(id);
    }

    @Override
    public Book getById(String id) {
        Book book = bookRepository.getById(id);
        if (book == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Buku tidak ditemukan");
        } 
        return book;
    }

    @Override
    public Book update(Book book) {
        getById(book.getId());
        bookRepository.updateBook(book.getTitle(), book.getPublisher(), book.getYear(), book.getPrice(), book.getCategory(), book.getCount(), book.getId());
        return book;
    }
}
