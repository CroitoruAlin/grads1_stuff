package com.endava.springbootday3part5.service;

import com.endava.springbootday3part5.model.Card;
import com.endava.springbootday3part5.model.CardDto;
import com.endava.springbootday3part5.model.User;
import com.endava.springbootday3part5.model.UserDetails;
import com.endava.springbootday3part5.proxy.CardServiceProxy;
import com.endava.springbootday3part5.repository.UserRepository;
import com.sun.tracing.dtrace.ArgsAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private CardServiceProxy cardServiceProxy;

    public void addUser(User user) {
        repository.addUser(user);
    }

    public UserDetails getUser(String username) {
        User user = repository.getUser(username);
        List<Card> cards = cardServiceProxy.getCardsOfUser(user.getId());
        UserDetails userDetails = new UserDetails();
        userDetails.setCards(cards);
        userDetails.setUser(user);
        return userDetails;
    }

    public void saveCard(CardDto cardDto) {
        User user = repository.getUser(cardDto.getUsername());
        Card card = cardDto.getCard();
        card.setUserId(user.getId());
        cardServiceProxy.saveCard(card);
    }

    public Card getCard(String username, String pan) {
        User user = repository.getUser(username);
        List<Card> cards = cardServiceProxy.getCardsOfUser(user.getId());
        System.out.println(cards);
        for(Card card:cards)
            if (card.getPan().equals(pan))
                return card;
        return null;
    }
}
