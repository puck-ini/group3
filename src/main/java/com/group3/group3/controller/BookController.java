package com.group3.group3.controller;

import com.group3.group3.entity.Book;
import com.group3.group3.entity.Result;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.BookServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.ResultUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @PostMapping("/insertBook")
    public Result insertBook(HttpServletRequest request,
                             @RequestParam(value = "bookName",required = false) String bookName,
                             @RequestParam(value = "lenDate",required = false) Date lenDate,
                             @RequestParam(value = "lend",required = false) String lend,
                             @RequestParam(value = "returnDate",required = false) Date returnDate,
                             @RequestParam(value = "userName",required = false) String userNmae){
        Book book = new Book();
        book.setBookName(bookName);
        book.setLenDate(lenDate);
        book.setLend(lend);
        book.setReturnDate(returnDate);
        book.setUserName(userNmae);
        Book book1 = bookService.insertBook(book);
        return ResultUtil.success(book1);
    }

    @GetMapping("/getAll")
    public Result getAll(HttpServletRequest request){
        List<Book> bookList = bookService.getAll();
        return ResultUtil.success(bookList);
    }

    @GetMapping("/getPersonBook")
    public Result getOne(HttpServletRequest request){
        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        List<Book> book = bookService.getPersonInfo(username);
        return ResultUtil.success(book);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "bookid",required = false) Integer bookid){
        bookService.deleteBook(bookid);
        return ResultUtil.success();
    }



}
