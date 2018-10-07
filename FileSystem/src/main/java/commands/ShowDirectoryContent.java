package commands;

import filesystem.AbstractFile;
import filesystem.Directory;
import permissions.Permissions;
import users.User;

public class ShowDirectoryContent implements Command {

    private Directory currentDirectory;
    private User currentUser;

    public ShowDirectoryContent(Directory currentDirectory,User user) {
        this.currentDirectory = currentDirectory;
        this.currentUser=user;
    }

    @Override
    public void execute() {

            for(AbstractFile abstractFile:currentDirectory.getFiles())
                System.out.println(abstractFile.getName()+" "+abstractFile.getSize());



    }
}
