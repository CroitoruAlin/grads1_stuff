package commands;

import filesystem.AbstractFile;
import filesystem.Directory;
import system.Terminal;
import permissions.Permissions;
import users.User;

public class ChangeDirectory implements Command {

    private Directory currentDirectory;
    private String name;
    private User currentUser;

    public ChangeDirectory(Directory currentDirectory, String name, User currentUser) {
        this.currentDirectory = currentDirectory;
        this.name = name;
        this.currentUser = currentUser;
    }

    @Override
    public void execute() {
        if (name.equals(".."))
            Terminal.updateCurrentDirectory(currentDirectory.getParent());
        else {
            AbstractFile file = currentDirectory.containsFileWithName(name);
            if (file != null && file instanceof Directory) {
                Terminal.updateCurrentDirectory((Directory) file);
            } else {
                System.out.println("This directory does not exist");
            }
        }
    }
}
