package main;

import beans.Pisica;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Pisica pisica = context.getBean(Pisica.class);
        }
        //se vor apela constructor, autowired fields, postconstructor
        // context.close determina distrugerea beanurilor
        //System.out.println(pisica);
    }
}
