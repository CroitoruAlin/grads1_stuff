package main;

import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CardService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        CardService service=context.getBean(CardService.class);
        boolean result=service.createCardIfNotExists("125687");
        if(result)
            System.out.println("Card has been added");
        else
            System.out.println("A card with this PAN already exists");
    }
}
