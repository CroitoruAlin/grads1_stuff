package system;

import filesystem.Directory;
import users.User;

import java.util.ArrayList;
import java.util.List;

public class Terminal {
    private static User currentUser;

    static {

        currentUser = new User("root");

    }

    private static List<User> users = new ArrayList<>();
    private static final Directory HOME_DIRECTORY = new Directory("home", null, currentUser);
    private static Directory currentDirectory = HOME_DIRECTORY;

    public static Directory getHome() {
        return HOME_DIRECTORY;
    }

    public static void updateCurrentDirectory(Directory directory) {
        if (directory != null)
            currentDirectory = directory;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static Directory getCurrentDirectory() {

        return currentDirectory;
    }

    public static void updateUsers(User user) {
        users.add(user);
    }

    public static User searchUserName(String name) {
        for (User user : users)
            if (user.getName().equals(name))
                return user;
        return null;
    }

    public static void updateCurrentUser(User user) {
        currentUser = user;
    }
}
