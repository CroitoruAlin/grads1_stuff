package grads;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication// dezavantaj la spring boot--descarca prea multe jar-uri si e posibil sa nu le folosim
public class Main {
    public static void main(String[] args) {// e foarte important sa existe un package principal,asta din cauza ca adnotarea SpringBootApplication
                                            //contine ComponentScan si EnableAutoConfiguration si Configuration, se uita peste ce se afla
                                            //  in acelasi pachet cu Main
        SpringApplication.run(Main.class,args);//isi creeaza un context in spate,in cazul asta creeaza un WebApplicationContext

    }
}
