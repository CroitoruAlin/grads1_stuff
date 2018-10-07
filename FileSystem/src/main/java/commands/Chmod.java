package commands;

import filesystem.AbstractFile;
import filesystem.Directory;
import filesystem.File;
import users.User;

public class Chmod implements Command {

    private User currentUser;
    private AbstractFile file;
    private String newPermissions;

    public Chmod(User currentUser, AbstractFile file,String newPermissions) {
        this.currentUser = currentUser;
        this.file=file;
        this.newPermissions=newPermissions;
    }

    @Override
    public void execute() {
        User fileOwner=file.getFileOwner();
        if(fileOwner.equals(fileOwner))
            file.setPermissions(Integer.valueOf(newPermissions));


    }
}
