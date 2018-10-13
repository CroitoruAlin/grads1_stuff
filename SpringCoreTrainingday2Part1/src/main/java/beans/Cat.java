package beans;

import org.springframework.stereotype.Component;

@Component
public class Cat {

    public void sayMeow()
    {
        System.out.println("Meow!");
    }
}
