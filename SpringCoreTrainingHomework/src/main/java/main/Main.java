package main;

import Services.CardService;
import Services.TransactionService;
import Services.UserService;
import config.Config;
import model.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
        UserService service=context.getBean(UserService.class);
        service.addUser("ionel","1234");
        System.out.println(service.getUserDetails("ionel"));
        CardService cardService=context.getBean(CardService.class);
        System.out.println(cardService.getCardDetails("125687"));
        TransactionService transactionService=context.getBean(TransactionService.class);
        System.out.println(transactionService.getTransactionOrderedByAmount("125687"));
    }
}
