package users;


import filesystem.Directory;
import system.Terminal;

import java.util.Objects;

public class User {

    private static long userIdCounter;

    static {
        userIdCounter = 0;
    }

    private String name;
    private long UID;
    public User(String name) {
        this.name = name;
        userIdCounter++;
        UID = userIdCounter;
        new Directory(name, Terminal.getHome(),this);
    }

    public String getName() {
        return name;
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return UID == user.UID &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, UID);
    }
}
