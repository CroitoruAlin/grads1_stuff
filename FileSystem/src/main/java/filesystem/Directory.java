package filesystem;

import users.User;

import java.util.ArrayList;
import java.util.Objects;

public class Directory extends AbstractFile {
    private ArrayList<AbstractFile> files;
    private long size;
    private Directory parent;


    public Directory(String name, Directory parent, User fileOwner) {
        super(name,fileOwner);
        files=new ArrayList<>();
        size=2;
        this.parent=parent;
        if(parent!=null)
        this.parent.updateSize(size);
    }
    public void addFile(AbstractFile file)
    {
        files.add(file);
        size+=file.getSize();
        if (parent!=null)
        parent.updateSize(file.getSize());
    }
    public void removeFile(AbstractFile file)
    {
        files.remove(file);
    }
    @Override
    public long getSize() {
        return size;
    }
    public AbstractFile containsFileWithName(String name)
    {
        for (AbstractFile file:files)
            if(file.getName().equals(name))
                return file;
            return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Directory directory = (Directory) o;
        return size == directory.size &&
                Objects.equals(files, directory.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), files, size);
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public ArrayList<AbstractFile> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<AbstractFile> files) {
        this.files = files;
    }



    public String getPath() {
        if (parent==null)
            return getName();
        return parent.getPath()+"/"+getName();
    }

    public void updateSize(long size) {
        this.size+=size;
        if(parent!=null)
            parent.updateSize(size);
    }
}
