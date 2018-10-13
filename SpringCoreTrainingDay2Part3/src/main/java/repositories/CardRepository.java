package repositories;

import entities.Card;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class CardRepository {

    @PersistenceContext //pentru injectare
    private EntityManager entityManager;

    public void addCard(Card c)
    {
        entityManager.persist(c);
    }
}
