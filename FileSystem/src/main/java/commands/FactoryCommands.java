package commands;

import filesystem.AbstractFile;
import filesystem.Directory;
import filesystem.File;
import permissions.Permission;
import permissions.PermissionRead;
import permissions.PermissionWrite;
import users.User;

public class FactoryCommands {

    public static final String PERMISSION = "You don't have permission";

    public static Command makeCommand(String[] commandName, Directory currentDirectory, User currentUser) {
        switch (commandName[0]) {
            case "touch": {
                Permission permission = new PermissionWrite(currentDirectory, currentUser);
                if (permission.verify())
                    return new CreateFile(commandName[1], currentDirectory, currentUser);
                else
                    System.out.println(PERMISSION);
                return null;
            }
            case "ls": {
                Permission permission = new PermissionRead(currentDirectory, currentUser);
                if (permission.verify())
                    return new ShowDirectoryContent(currentDirectory, currentUser);
                else
                    System.out.println(PERMISSION);
                return null;
            }
            case "cd": {
                Permission permission = new PermissionRead(currentDirectory, currentUser);
                if (permission.verify())
                    return new ChangeDirectory(currentDirectory, commandName[1], currentUser);
                else
                    System.out.println(PERMISSION);
                return null;
            }
            case "mkdir": {
                Permission permission = new PermissionWrite(currentDirectory, currentUser);
                if (permission.verify())
                    return new Mkdir(currentDirectory, commandName[1], currentUser);
                else
                    System.out.println(PERMISSION);
                return null;
            }
            case "useradd": {
                return new CreateUser(commandName[1]);
            }
            case "su": {
                return new ChangeUser(commandName[2]);
            }
            case "pwd": {
                return new PWD(currentDirectory);
            }
            case "echo": {
                switch (commandName.length) {
                    case 2: {

                        return new Echo(null, commandName);
                    }
                    case 4: {
                        for (AbstractFile file : currentDirectory.getFiles()) {
                            if (file.getName().equals(commandName[3]) && file instanceof File) {
                                Permission permission = new PermissionWrite(file, currentUser);
                                if (permission.verify())
                                    return new Echo((File) file, commandName);
                            }

                        }
                        return null;
                    }
                    default: {
                        System.out.println("Invalid input");
                        return null;
                    }
                }
            }
            default:
                return null;
        }
    }
}
