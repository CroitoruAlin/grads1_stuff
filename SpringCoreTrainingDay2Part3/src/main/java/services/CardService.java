package services;

import entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.CardRepository;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    @Transactional//rollbackFor =Exception.class determina un rollback si pt checked exception
                    //norollbackFor=RuntimeException.class va face commit chiar daca este un unchecked exception
                    //propagation=Propagation.Required-nivel de propagare  default,daca exista deja o tranzactie atunci se foloseste
                                                        // acea tranzactie,daca nu exista creeaza una
                                  //requires_new -creeaza o tranzactie pentru aceea metoda indiferente daca exista una sau nu
                                  //supports - daca vine o tranzactie o foloseste pe aceea, daca nu se executa fara
                                  //not supported - indiferent daca vine tranzactie sau nu executa fara tranzactie
                                  //mandatory daca exista o tranzactie este folosita aceea tranzactie, daca nu crapa cu exceptie,
                                    //folosit adesea pe repository
                                  //nested - creeaza o tranzactie in tranzactie
                                  //never- impiedica existenta unei tranzactii
                        //propagation pus la nivel de metoda suprascrie pe cel de pe clasa
    public void addCard(String pan)
    {
        Card card=new Card();
        card.setPan(pan);
        cardRepository.addCard(card);
    }
}
