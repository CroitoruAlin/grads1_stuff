package com.endava.springbootday3part4.repository;

import com.endava.springbootday3part4.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addCard(Card card) {
        String sql = "insert into card values(null,?,?)";
        jdbcTemplate.update(sql, card.getPan(), card.getUserId());
    }

    public Card getCard(String pan) {
        String sql = "select * from card where pan = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (resultSet, i) -> {
                Card card = new Card();
                card.setId(resultSet.getInt("id"));
                card.setPan(resultSet.getString("pan"));
                card.setUserId(resultSet.getInt("user_id"));
                return card;
            }, pan);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Card> getCards(Integer userId) {
        String sql="select * from card where user_id = ?";
        Integer[] ids={userId};
        return jdbcTemplate.query(sql,ids,(resultSet,i) ->{
            Card card=new Card();
            card.setUserId(resultSet.getInt("user_id"));
            card.setPan(resultSet.getString("pan"));
            card.setId(resultSet.getInt("id"));
            return card;
        } );
    }
}
