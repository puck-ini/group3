package com.group3.group3.service;

import com.group3.group3.entity.Card;

import java.util.List;

public interface CardService {

    Card insertCard(Card card);

    Card deleteCard(Integer cardid);

    List<Card> getAll();

    List<Card> getPersonCardInfo(String username);

}
