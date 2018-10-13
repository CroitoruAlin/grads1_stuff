package repositories;

import entities.Card;

public class CardRepository {
    public void saveCard(Card card)
    {
        System.out.println("A fost salvat cardul in bd");
    }
    public Card getCardByPan(String pan)
    {
        Card card=new Card();
        card.setPan(pan);
        return card;
    }
}
