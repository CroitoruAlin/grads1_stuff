package commands;

import filesystem.Directory;
import permissions.Permissions;
import users.User;

public class Mkdir implements Command {
    private Directory currentDirectory;
    private String name;
    private User currentUser;

    public Mkdir(Directory currentDirectory, String name, User currentUser) {
        this.currentDirectory = currentDirectory;
        this.name = name;
        this.currentUser = currentUser;
    }

    public Mkdir(Directory currentDirectory) {
        this.currentDirectory = currentDirectory;
    }

    @Override
    public void execute() {

        currentDirectory.addFile(new Directory(name, currentDirectory, currentUser));


    }
}
