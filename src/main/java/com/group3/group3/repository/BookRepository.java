package com.group3.group3.repository;

import com.group3.group3.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findAllByUserName(String userName);
}
