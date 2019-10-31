package com.group3.group3.service.impl;

import com.group3.group3.entity.Card;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.repository.CardRepository;
import com.group3.group3.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {



    @Autowired
    private CardRepository cardRepository;


    @Override
    public Card insertCard(Card card) {
        verifyUid(card.getUid());
        cardRepository.save(card);
        return card;
    }

    private void verifyUid(Integer uid){
        List<Card> employmentList = cardRepository.findByUid(uid);
        if (employmentList.size() != 0){
            throw new HandleException(ExceptionEnum.EXIST_USER);
        }
    }

    @Override
    public Card deleteCard(Integer cardid) {
        cardRepository.deleteById(cardid);
        return null;
    }

    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @Override
    public List<Card> getPersonCardInfo(String username) {
        return cardRepository.findByUsername(username);
    }
}
