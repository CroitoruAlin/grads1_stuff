package Services;

import model.User;
import model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addUser(String username,String password)
    {

        if(userRepository.getUserByUsername(username)==null) {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            userRepository.saveUser(user);
        }

    }
    @Transactional
    public List<UserDetails> getUserDetails(String username)
    {
        return userRepository.getUserDetails(username);
    }
}
