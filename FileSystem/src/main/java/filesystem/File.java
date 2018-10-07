package filesystem;

import users.User;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

public class File extends AbstractFile {

    private long size;
    private String content;
    private Directory parent;


    public File(String name, Directory parent, User fileOwner) {

        super(name,fileOwner);
        this.size = 0;
        this.parent=parent;
    }

    public void setContent(String content) {
        this.content = content;
        try {
            size+=content.getBytes("UTF-8").length;
            parent.updateSize(size);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return size == file.size &&
                Objects.equals(content, file.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, content);
    }

}
