package permissions;

import filesystem.AbstractFile;
import users.User;

public class PermissionRead implements Permission {
    private AbstractFile file;
    private User currentUser;

    public PermissionRead(AbstractFile file, User currentUser) {
        this.file = file;
        this.currentUser = currentUser;
    }

    @Override
    public boolean verify() {
        User fileOwner = file.getFileOwner();
        if (fileOwner.equals(currentUser)) {
            if ((file.getOwnerPermissions() & Permissions.READ.getValue()) == Permissions.READ.getValue()) {
                return true;
            }} else if ((file.getOthersPermissions() & Permissions.READ.getValue()) == Permissions.READ.getValue()) {
                return true;
            }
        return false;
    }
}
