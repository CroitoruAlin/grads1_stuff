package main;

import model.Baterie;
import model.Mouse;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class))
        {
            Baterie baterie=context.getBean(Baterie.class);
            System.out.println(baterie);
        }
    }
}
