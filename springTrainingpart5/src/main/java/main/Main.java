package main;

import beans.Baterie;
import beans.Mouse;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContex = new AnnotationConfigApplicationContext(AppConfig.class);
        Baterie baterie = applicationContex.getBean(Baterie.class);
        System.out.println(baterie.getVoltaj());
        Mouse mouse = applicationContex.getBean(Mouse.class);
        System.out.println(mouse.getBaterie());
    }
}
