package com.group3.group3.service.impl;


import com.group3.group3.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceImplTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BookServiceImpl bookService;

    @Test
    public void insertBook() throws Exception {
        Book book = new Book();
        book.setBookName("高数");
        book.setUserName("sds");
        Book book1 = bookService.insertBook(book);
        log.info(book.toString());
    }

    @Test
    public void deleteBook() throws Exception{
        Integer bookid = 1;
        Book book = bookService.deleteBook(bookid);

    }

    @Test
    public void getPersonInfo() throws Exception{
        String username = "sds";
        List<Book> bookList = bookService.getPersonInfo(username);
        log.info(bookList.toString());

    }

    @Test
    public void getAll() throws Exception{
        List<Book> list = bookService.getAll();
        log.info(list.toString());
    }
}
