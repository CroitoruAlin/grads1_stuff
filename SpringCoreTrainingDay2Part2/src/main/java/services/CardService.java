package services;

import model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.CardRepository;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Transactional//SE VA COMPORTA CA O TRANZACTIE CARE TREBUIE ACTIVAT IN CLASA DE CONFIG
    public boolean createCardIfNotExists(String pan)
    {

        if(cardRepository.findCardByPan(pan)==null)
        {
            Card card = new Card();
            card.setPan(pan);
            cardRepository.saveCard(card);
            return true;
        }
        return false;
    }
}
