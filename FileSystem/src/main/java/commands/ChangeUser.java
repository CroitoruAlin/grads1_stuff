package commands;

import system.Terminal;
import users.User;

public class ChangeUser implements Command {

    private String newUser;

    public ChangeUser(String newUser) {
        this.newUser = newUser;
    }

    @Override
    public void execute() {
        User user = Terminal.searchUserName(newUser);
        if (user != null) {
            Terminal.updateCurrentUser(user);

        }
    }
}
