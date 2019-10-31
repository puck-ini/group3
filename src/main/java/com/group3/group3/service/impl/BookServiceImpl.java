package com.group3.group3.service.impl;

import com.group3.group3.entity.Book;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.BookRepository;
import com.group3.group3.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;


    @Override
    public Book insertBook(Book book) {
        bookRepository.save(book);
        return book;
    }


    @Override
    public Book deleteBook(Integer bookid) {
        bookRepository.deleteById(bookid);
        return null;
    }

    @Override
    public List<Book> getPersonInfo(String username) {
        return bookRepository.findAllByUserName(username);
    }


    @Override
    public List<Book> getAll() { return bookRepository.findAll(); }
}
