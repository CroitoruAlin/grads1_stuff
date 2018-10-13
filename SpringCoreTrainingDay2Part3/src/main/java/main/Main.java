package main;

import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CardService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean(CardService.class).addCard("12345");
    }
}
