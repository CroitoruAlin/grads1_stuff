package java8.interfaces.functional;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class JavaProvidedFunctionalInterfaceExample {
    public static void main(String[] args) {
        // Function
        Function<String, String> quote = s -> "'" + s + "'";
        //TODO call single abstract method
        Function<String, Integer> length = s -> s.length();
        System.out.println(quote.apply("Alta intrebare!"));
        System.out.println(length.apply("start"));
        // Supplier
        Supplier<Double> lazyValue = () -> 9d;
        //TODO call single abstract method
        System.out.println(lazyValue.get());

        // Consumer
        Consumer<Integer> doubler = number -> System.out.println(number * 2);
        //TODO call single abstract method
        doubler.accept(23);
        // Predicate
        Predicate<Integer> isEven = number -> number % 2 == 0;
        //TODO call single abstract method
        System.out.println(isEven.test(5));

        // UnaryOperator
        UnaryOperator<String> toUpper = word -> word.toUpperCase();
        //TODO call single abstract method
        System.out.println(toUpper.apply("salut"));

        // BinaryOperator
        BinaryOperator<Integer> addNumbers = (a, b) -> a + b;
        //TODO call single abstract method
        System.out.println(addNumbers.apply(2, 3));

        // Primitive
        //  http://karols.github.io/blog/2015/08/08/java-8-functional-interfaces-cheatsheet/

    }

}