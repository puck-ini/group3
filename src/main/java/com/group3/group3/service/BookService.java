package com.group3.group3.service;

import com.group3.group3.entity.Book;

import java.util.List;

public interface BookService {

    Book insertBook(Book book);

    Book deleteBook(Integer bookid);

    List<Book> getPersonInfo(String username);

    List<Book> getAll();
}
