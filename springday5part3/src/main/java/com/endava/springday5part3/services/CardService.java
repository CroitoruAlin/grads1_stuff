package com.endava.springday5part3.services;

import com.endava.springday5part3.model.Card;
import com.endava.springday5part3.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card addCard(Card card){
        cardRepository.save(card);
        return card;

    }

    public List<Card> getCards() {
        return cardRepository.findAll();
    }
}
