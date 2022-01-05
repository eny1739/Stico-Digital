package com.heroku.service;

import com.heroku.entity.Book;
import com.heroku.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;

    private String getUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        while (bookRepository.findById(uuid).isPresent()){
            uuid = UUID.randomUUID().toString().replaceAll("-","");
        }
        return uuid;
    }

    @Override
    public Book create(Book book) {
        String uuid = getUUID();
        bookRepository.createBook(uuid, book.getTitle(), book.getPublisher(), book.getYear(), book.getPrice(), book.getCategory(), book.getCount());
        return getById(uuid);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.getAllBook().stream().collect(Collectors.toList());
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
