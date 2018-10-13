package main;

import beans.Baterie;
import beans.Human;
import beans.Mouse;
import config.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfiguration.class);
        Human human = context.getBean(Human.class);
        Baterie baterie1 =context.getBean(Baterie.class);
        baterie1.setVoltaj(20);
        Mouse mouse1 = context.getBean(Mouse.class);
        System.out.println(baterie1);
        System.out.println( human.getBaterie());
        System.out.println(mouse1.getBaterie());

    }
}
