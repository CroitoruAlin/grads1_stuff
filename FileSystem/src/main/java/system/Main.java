package system;

import commands.Command;
import commands.FactoryCommands;
import filesystem.Directory;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Terminal.updateCurrentDirectory(Terminal.getHome());
        Terminal.getHome().setPermissions(77);
        while (true) {
            try {


                System.out.println("Logged in as " + Terminal.getCurrentUser().getName());
                System.out.println(Terminal.getCurrentDirectory() + ">");
                String line = scanner.nextLine();
                String[] commandAndArgs = line.split(" ");
                Command command = FactoryCommands.makeCommand(commandAndArgs, Terminal.getCurrentDirectory(), Terminal.getCurrentUser());
                command.execute();
            } catch (NullPointerException nullException) {
                System.err.println("Invalid Input");
            }

        }
    }

}
