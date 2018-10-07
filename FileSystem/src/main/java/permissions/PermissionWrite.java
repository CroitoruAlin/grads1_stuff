package permissions;

import filesystem.AbstractFile;
import users.User;

public class PermissionWrite implements Permission {
    private AbstractFile file;
    private User currentUser;

    public PermissionWrite(AbstractFile file, User currentUser) {
        this.file = file;
        this.currentUser = currentUser;
    }

    @Override
    public boolean verify() {
        User fileOwner = file.getFileOwner();
        if (fileOwner.equals(currentUser)) {
            if ((file.getOwnerPermissions() & Permissions.WRITE.getValue()) == Permissions.WRITE.getValue()) {
                return true;
            }} else if ((file.getOthersPermissions() & Permissions.WRITE.getValue()) == Permissions.WRITE.getValue()) {
            return true;
        }
        return false;
    }
}
