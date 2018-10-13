package com.endava.springbootday3part5.repository;

import com.endava.springbootday3part5.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user)
    {
        String sql="insert into user values(null,?,?)";
        jdbcTemplate.update(sql,user.getUsername(),user.getPassword());
    }

    public User getUser(String username) {
        String sql="select * from user where username=?";
        return jdbcTemplate.queryForObject(sql,(resultSet,i)->
        {
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            return user;
        },username);
    }
}
