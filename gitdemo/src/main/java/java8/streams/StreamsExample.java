package java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {
    public static void main(String[] args) {
        // terminal vs intermediate
        Stream<String> myStream=Stream.of("ala","bala","portocala","303meree","mere","in","panere");
       // myStream.filter(word->word.length()>4).sorted().forEach(System.out::println);
        // not reusables
       // myStream.forEach(System.out::println);//nu va merge fiindca a fost utilizat inainte
        //metoda peek arata puncte intermediare
        //metodele intermediare sunt lenese, nu se apeleaza fara o metoda terminala
        //add to a list with Stream.of

        //filter list
        myStream.filter(word->word.contains("a")||word.contains("A")).forEach(System.out::println);
        // for each element print it

        // sorted
        Stream<Integer> ints=Stream.of(213,21,1,97,34,6789);
       // List<Integer> integerList=ints.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //System.out.println(integerList);
        // map


        // match -> any, all, none
        //System.out.println(ints.allMatch(number->number>5));
        //System.out.println(ints.anyMatch(number->number>600));
        //System.out.println(ints.noneMatch(number->number>7000));
        // count

        //System.out.println(ints.count());

        // reduce

        //System.out.println(ints.reduce((a, b) -> a + b).orElse(0));

        // parallel streams
        ints.parallel();
        List<String> myList=new ArrayList<>();
        myList.stream();
        myList.parallelStream();

    }
}
