package com.endava.springbootday3part4.controller;

import com.endava.springbootday3part4.model.Card;
import com.endava.springbootday3part4.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardServiceController {
    @Autowired
    private CardService cardService;
    @PostMapping("/card/add")
    public void addCard(@RequestBody Card card)
    {
        cardService.addCard(card);
    }
    @GetMapping("/card/get/{pan}")
    public Card getCard(@PathVariable("pan") String pan)
    {
        return cardService.getCard(pan);
    }
    @GetMapping("/card/get/details/{userId}")
    public List<Card> getCards(@PathVariable("userId") Integer userId)
    {
        return cardService.getCards(userId);
    }
}
