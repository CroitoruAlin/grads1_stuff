package repositories;


import model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CardRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveCard(Card card) {
        String sql = "insert into card values (null,?)";
        jdbcTemplate.update(sql, card.getPan());
    }

    public Card findCardByPan(String pan) {
        String sql = "select * from card where pan = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
                        Card card = new Card();
                        card.setPan(resultSet.getString("pan"));
                        return card;
                    }
                    , pan);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException)
        {
            System.out.println("Excepptie");
        }


        return null;
    }
}
