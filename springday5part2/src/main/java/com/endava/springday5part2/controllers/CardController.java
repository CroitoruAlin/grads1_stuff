package com.endava.springday5part2.controllers;

import com.endava.springday5part2.model.Card;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/card")
@CrossOrigin(origins = "*")
public class CardController {

    @GetMapping("/all")
    public List<Card> getCards()
    {
        List<Card> cards=new ArrayList<>();
        cards.add(new Card("1234"));
        cards.add(new Card("4321"));
        cards.add(new Card("234243"));
        return cards;
    }
    @PostMapping("/add")
    public String addCard(@RequestBody Card card)
    {
        System.out.println("Card was added");
        return "Card was added";//clientul asteapta un json
    }
}
