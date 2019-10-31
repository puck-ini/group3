package com.group3.group3.controller;


import com.group3.group3.entity.Card;
import com.group3.group3.entity.Result;
import com.group3.group3.enums.ExceptionEnum;
import com.group3.group3.exception.HandleException;
import com.group3.group3.service.impl.CardServiceImpl;
import com.group3.group3.util.CookieUtil;
import com.group3.group3.util.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.group3.group3.util.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardServiceImpl cardService;

    @PostMapping("/insertCard")
    public Result insertCard(HttpServletRequest request,
                             @RequestParam(value = "uid",required = false) Integer uid,
                             @RequestParam(value = "username",required = false) String username,
                             @RequestParam(value = "balance",required = false) Double balance){
        Card card = new Card();
        card.setUid(uid);
        card.setUsername(username);
        card.setBalance(balance);
        Card card1 = cardService.insertCard(card);
        return ResultUtil.success(card1);
    }

    @GetMapping("/getAllCard")
    public Result getCardInfo(){
        List<Card> cardList = cardService.getAll();
        return ResultUtil.success(cardList);
    }

    @GetMapping("/getPersonCard")
    public Result getOne(HttpServletRequest request){
        String username;
        try {
            Claims claims = TokenUtil.parseToken(CookieUtil.get(request, "Token").getValue());
            username = claims.getId();
        }catch (Exception e){
            throw new HandleException(ExceptionEnum.UNKNOWN_LOGIN);
        }
        List<Card> card = cardService.getPersonCardInfo(username);
        return ResultUtil.success(card);
    }

    @GetMapping("/delete")
    public Result delete(HttpServletRequest request,
                         @RequestParam(value = "cardid",required = false) Integer cardid){
        cardService.deleteCard(cardid);
        return ResultUtil.success();
    }
}
