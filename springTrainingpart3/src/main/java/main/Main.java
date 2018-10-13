package main;

import beans.Mouse;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class))
        {
            Mouse mouse=context.getBean(Mouse.class);
            System.out.println(mouse.getBaterie());
        }
    }
}
