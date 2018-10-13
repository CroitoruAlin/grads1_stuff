package services;

import entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CardRepository;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    private void addCardIfNotExists(String pan)
    {
        Card card=cardRepository.getCardByPan(pan);
        if (card==null) {
            card = new Card();
            card.setPan(pan);
            cardRepository.saveCard(card);
        }
    }
}
