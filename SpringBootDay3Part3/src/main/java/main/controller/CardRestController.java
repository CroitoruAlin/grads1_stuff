package main.controller;


import main.model.Card;
import main.service.CardRestService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardRestController {

    @Autowired
    private CardRestService cardRestService;

    @GetMapping("/card")
    public Card getCard()
    {
        return cardRestService.getCard();
    }
}
