package java8.methodReferences;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReferenceExample {

    public static void main(String[] args) {

        // static methods
        List<String> books = Arrays.asList("Harry Potter", "Dune","Concentrat","Fratii Karamazov");
       // books.forEach(book-> System.out.println(book));
       // books.forEach(System.out::println);
      //  books.forEach(DummyClass::display);

        //TODO

        // instance methods

        DummyClass ref = new DummyClass();
        Stream<Integer> numbers = Stream.of(3, 10, 8, 43, 61, 32, 5, 24);
        List<Integer> listNumbers = Arrays.asList(3, 10, 8, 43, 61, 32, 5, 24);
        listNumbers.stream().filter(ref::isEven).forEach(System.out::println);

        //System.out.println(numbers.filter(ref::isEven).collect(Collectors.toList()));

        //TODO

        //constructor reference
        List<String> strList = Arrays.asList("1","2","3");
        List<Integer> intList = strList.stream().map(Integer::new).collect(Collectors.toList());//prin Integer::new se apeleaza un constructor
        List<Float> floatList = strList.stream().map(Float::new).collect(Collectors.toList());
        System.out.println(intList);
        System.out.println(floatList);

        //TODO
    }
}

