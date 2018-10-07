package filesystem;

import permissions.Permissions;
import users.User;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class AbstractFile {
    private String name;
    private LocalDateTime localDateTime;
    private User fileOwner;
    private Integer permissions;



    public AbstractFile(String name,User fileOwner) {
        this.name = name;
        localDateTime=LocalDateTime.now();
        permissions=Permissions.READ.getValue()|Permissions.WRITE.getValue()|Permissions.EXECUTE.getValue();
        permissions=permissions*10+Permissions.WRITE.getValue();
        this.fileOwner=fileOwner;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }

    public Integer getOwnerPermissions() {
        return permissions/10;
    }
    public Integer getOthersPermissions()
    {
        return permissions%10;
    }

    public String getName() {
        return name;
    }

    public User getFileOwner() {
        return fileOwner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setFileOwner(User fileOwner) {
        this.fileOwner = fileOwner;
    }



    @Override
    public String toString() {
        return name;
    }

    public abstract long getSize();
    public LocalDateTime getLocalDateTime()
    {
        return localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFile that = (AbstractFile) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(fileOwner, that.fileOwner);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fileOwner);
    }
}
