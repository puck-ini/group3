package com.group3.group3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookid;

    private String bookName;

    private String lend;

    private String userName;

    private Date lenDate;

    private Date returnDate;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getLend() {
        return lend;
    }

    public void setLend(String lend) {
        this.lend = lend;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLenDate() {
        return lenDate;
    }

    public void setLenDate(Date lenDate) {
        this.lenDate = lenDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString(){
        return "Book{" +
                "bookid=" + bookid +
                ", book_name='" + bookName + '\'' +
                ", lend='" + lend + '\'' +
                ", len_date='" + lenDate + '\'' +
                ", return_date='" + returnDate + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
