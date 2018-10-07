package permissions;

import filesystem.AbstractFile;
import users.User;

public class PermissionExecute implements Permission {
    private AbstractFile file;
    private User currentUser;

    public PermissionExecute(AbstractFile file, User currentUser) {
        this.file = file;
        this.currentUser = currentUser;
    }

    @Override
    public boolean verify() {
        User fileOwner = file.getFileOwner();
        if (fileOwner.equals(currentUser)) {
            if ((file.getOwnerPermissions() & Permissions.EXECUTE.getValue()) == Permissions.EXECUTE.getValue()) {
                return true;
            }} else if ((file.getOthersPermissions() & Permissions.EXECUTE.getValue()) == Permissions.EXECUTE.getValue()) {
            return true;
        }
        return false;
    }
}
