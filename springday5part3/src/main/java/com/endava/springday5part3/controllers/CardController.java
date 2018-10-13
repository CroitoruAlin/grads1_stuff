package com.endava.springday5part3.controllers;

import com.endava.springday5part3.model.Card;
import com.endava.springday5part3.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CardController {
    @Autowired
    public CardService cardService;

    @PostMapping("/add")
    public Card addCard(@RequestBody Card card)
    {
        return cardService.addCard(card);
    }

  @GetMapping("/get")
    public List<Card> getCards()
    {
        return cardService.getCards();
    }
   // @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id)
    {

    }

}
