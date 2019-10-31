package com.group3.group3.service.impl;

import com.group3.group3.entity.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CardServiceImplTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private CardServiceImpl cardService;


    @Test
    public void insertCard() throws Exception{
        Card card = new Card();
        card.setUid(4);
        card.setBalance(400.00);
        Card card1 = cardService.insertCard(card);
        log.info(card.toString());
    }

    @Test
    public void deleteCard() throws Exception{
        Integer uid = 2;
        Card card = cardService.deleteCard(uid);
    }

    @Test
    public void getAll() throws Exception{
        List<Card> list = cardService.getAll();
        log.info(list.toString());
    }

    @Test
    public void getPersonCardInfo() throws Exception{
        String username = "sds";
        List<Card> list = cardService.getPersonCardInfo(username);
        log.info(list.toString());
    }
}
