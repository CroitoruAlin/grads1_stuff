package config;

import beans.Baterie;
import beans.Mouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Baterie baterie() {
        Baterie baterie = new Baterie();
        baterie.setVoltaj(100);
        return baterie;
    }

    @Autowired
    @Bean
    public Mouse mouse(Baterie baterie) {
        Mouse mouse = new Mouse();
        mouse.setBaterie(baterie);// in realitate nu apeleaza metoda baterie() ci ia instanta din context-ul Spring
        return mouse;
    }

    /*@Autowired
    @Bean
    public Mouse mouse(Baterie baterie) echivalenta cu metoda anterioara, de la 4.3+ este optional Autowired-ul pe functia asta
    {
        Mouse mouse=new Mouse();
        mouse.setBaterie(baterie);// in realitate nu apeleaza metoda baterie() ci ia instanta din context-ul Spring
        return mouse;
    }*/
}
