package repositories;


import model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TransactionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Transaction> getTransactionOrderedByAmount(String pan)
    {
        String sql="select t.* from card c join transaction t on(c.id=t.card_id) where pan = ? order by amount";
        String[] args={pan};
        return jdbcTemplate.query(sql,args,(resultSet,i)->
        {
            Transaction transaction=new Transaction();
            transaction.setAmount(resultSet.getDouble("amount"));
            transaction.setCard_id(resultSet.getInt("card_id"));
            return transaction;
        });

    }
}
