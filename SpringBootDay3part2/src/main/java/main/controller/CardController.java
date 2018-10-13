package main.controller;


import main.model.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CardController {

    @GetMapping(value = "/card")//RequestMapping(value="..",method=RequestMethod.GET),parametrul produces specifica ce fel de rez intoarce
    public Card retrieveCard()
    {
           return new Card("123gfs");
    }

    @GetMapping(value = "/cards")
    public List<Card> retrieveCards()
    {
        Card card1=new Card("1234");
        Card card2=new Card("1234asd");
        Card card3=new Card("1234sdf");
        return Arrays.asList(card1,card2,card3);
    }
}
