package repositories;

import model.CardDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CardDetails> getCardDetails(String pan)
    {
        String sql= "select * from card c join transaction t on(t.card_id=c.id) where c.pan = ?";
        String[] args={pan};
       return jdbcTemplate.query(sql,args,(resultSet,i)->
        {
            CardDetails cardDetails=new CardDetails();
            cardDetails.setAmount(resultSet.getDouble("amount"));
            cardDetails.setPan(resultSet.getString("pan"));
            return cardDetails;
        });
    }
}
