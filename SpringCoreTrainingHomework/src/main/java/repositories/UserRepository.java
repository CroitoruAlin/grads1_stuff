package repositories;


import com.sun.org.apache.regexp.internal.RESyntaxException;
import model.User;
import model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

    public User getUserByUsername(String username)
    {
        String sql="select * from user where username= ? ";
        try {


            return jdbcTemplate.queryForObject(sql, UserRepository::mapRow, username);
        }catch (EmptyResultDataAccessException emptyResultDataAccessException)
        {
            System.out.println("Exceptie");
        }
        return null;
    }
    public void saveUser(User user)
    {
        String sql="insert into user values(null,?,?)";
        jdbcTemplate.update(sql,user.getUsername(),user.getPassword());
    }
    public List<UserDetails> getUserDetails(String username)
    {

        String sql="select * from user u join card c on(c.user_id=u.id) " +
                   "join transaction t on(t.card_id=c.id) where username= ?";


       String[] args={username};
       return jdbcTemplate.query(sql,args,(resultSet,i)->{
           UserDetails userDetails=new UserDetails();
           userDetails.setUsername(resultSet.getString("username"));
           userDetails.setAmount(resultSet.getDouble("amount"));
           userDetails.setPan(resultSet.getString("pan"));
           userDetails.setPassword(resultSet.getString("password"));
           return userDetails;
       });
    }
}
