package com.endava.springbootday3part5.model;

import java.util.List;

public class UserDetails {

    private User user;
    private List<Card> cards;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
