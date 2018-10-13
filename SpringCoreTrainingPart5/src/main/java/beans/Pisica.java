package beans;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Pisica {

    public Pisica() {
        System.out.println("S-a apelat constructorul");
    }

    @PostConstruct
    public void init()
    {
        System.out.println("S-a initializat bean-ul");
    }


    @PreDestroy
    public void destroy()
    {
        System.out.println("bean-ul a fost distrus");
    }

    @Override
    public String toString() {
        return "Pisica{}";
    }
}
