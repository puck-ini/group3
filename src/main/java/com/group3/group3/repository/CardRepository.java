package com.group3.group3.repository;

import com.group3.group3.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CardRepository extends JpaRepository<Card,Integer> {
    List<Card> findByUid(Integer uid);
    List<Card> findByUsername(String username);
}
