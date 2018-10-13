package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("beans,aspects")
@EnableAspectJAutoProxy//activeaza functionalitatea de aspectare
public class AppConfig {
}
