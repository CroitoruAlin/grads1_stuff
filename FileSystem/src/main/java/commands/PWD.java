package commands;

import filesystem.Directory;

public class PWD implements Command {
    private Directory currentDirectory;
    public PWD(Directory currentDirectory) {
        this.currentDirectory=currentDirectory;
    }

    @Override
    public void execute() {
        System.out.println(currentDirectory.getPath());
    }
}
