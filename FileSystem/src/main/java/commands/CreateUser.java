package commands;


import system.Terminal;
import users.User;


public class CreateUser implements Command {


    private String userToAdd;

    public CreateUser(String name) {
        userToAdd=name;
    }

    @Override
    public void execute() {
        Terminal.updateUsers(new User(userToAdd));
    }
}
