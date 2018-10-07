package commands;

import filesystem.AbstractFile;
import filesystem.File;

public class Echo implements Command {
    private File file;
    private String commandParams[];

    public Echo(File file, String[] commandParams) {
        this.file = file;
        this.commandParams = commandParams;
    }

    @Override
    public void execute() {
        switch (commandParams.length) {
            case 2: {
                System.out.println(commandParams[1]);
                break;
            }
            case 4: {
                file.setContent(commandParams[1]);

                break;
            }
            default:
                System.out.println("Invalid input");
        }


    }
}
