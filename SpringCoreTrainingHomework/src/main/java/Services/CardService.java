package Services;


import model.CardDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.CardRepository;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Transactional
    public List<CardDetails> getCardDetails(String pan)
    {
        return cardRepository.getCardDetails(pan);
    }
}
