package commands;

import filesystem.File;

public class Cat implements Command{
    private File file;

    public Cat(File file) {
        this.file = file;
    }

    @Override
    public void execute() {
        System.out.println(file.getContent());
    }
}
