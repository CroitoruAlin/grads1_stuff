package config;

import beans.Baterie;
import beans.Mouse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    @Bean
    public Mouse mouse()
    {
        System.out.println("Mouse");
        return new Mouse();
    }

    @Bean
    //@Primary // seteaza acest bean ca fiind superior fata de celalalt care returneaza acelasi tip
    public Baterie baterie1() {
        System.out.println("Baterie1");
        return new Baterie();
    }


}
