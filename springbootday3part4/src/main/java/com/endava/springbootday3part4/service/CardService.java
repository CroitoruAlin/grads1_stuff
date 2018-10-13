package com.endava.springbootday3part4.service;

import com.endava.springbootday3part4.model.Card;
import com.endava.springbootday3part4.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public void addCard(Card card)
    {
        cardRepository.addCard(card);

    }
    public Card getCard(String pan)
    {
        return cardRepository.getCard(pan);
    }

    public List<Card> getCards(Integer userId) {
        return cardRepository.getCards(userId);
    }
}
