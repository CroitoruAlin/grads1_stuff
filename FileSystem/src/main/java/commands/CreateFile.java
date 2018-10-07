package commands;

import filesystem.Directory;
import filesystem.File;
import permissions.Permissions;
import users.User;

public class CreateFile implements Command {

    private String name;
    private Directory currentDirectory;
    private User currentUser;

    public CreateFile(String name, Directory currentDirectory, User currentUser) {
        this.name = name;
        this.currentDirectory = currentDirectory;
        this.currentUser = currentUser;

    }


    @Override
    public void execute() {

            currentDirectory.addFile(new File(name,currentDirectory,currentUser));


    }
}
