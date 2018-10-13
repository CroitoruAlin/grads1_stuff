package config;

import beans.Baterie;
import beans.Human;
import beans.Mouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public Mouse mouse()
    {
        System.out.println("Mouse");
        return new Mouse();
    }
    @Bean
    public Baterie baterie()
    {
        System.out.println("Baterie");
        return new Baterie();
    }
    @Bean
    public Human human()
    {
        System.out.println("Human");
        return new Human();
    }

}
