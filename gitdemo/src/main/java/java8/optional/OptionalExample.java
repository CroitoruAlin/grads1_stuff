package java8.optional;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> one = Optional.empty();
        //TODO uncomment the next line
        //  one.get(); exception

        String str = "value";
        Optional<String> two = Optional.of(str);
        //TODO uncomment the next line
        System.out.println(two.get());

    //TODO uncomment the next line
//        Optional<String> three = Optional.of(null);--crapa pentru ca of nu se asteapta sa primeasca null


        Optional<String> four = Optional.ofNullable(null);
        //TODO uncomment the next line
//        four.get();

        Optional<String> five = Optional.ofNullable("str");
        //TODO print the next line
        //five.get();

        Optional<String> six = Optional.ofNullable(null);
        //TODO print the next line
        System.out.println(six.orElse("a non-null value"));

        Optional<String> seven = Optional.ofNullable("abcfdf");
        //TODO uncomment the next line
//        six.orElseThrow(CustomException::new);arunca exceptia care este data ca parametru daca six e null

        five.ifPresent(System.out::println);
        seven.ifPresent(System.out::println);
        if(seven.isPresent())
        {
            System.out.println(seven.get());
        }
        else
        {
            System.out.println("else");
        }
        seven.ifPresent((string)-> System.out.println(string));
        //TODO look at isPresent
    }
}
