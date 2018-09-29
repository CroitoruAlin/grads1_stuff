package java8.dateTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterExample {

    public static void main(String[] args) {

        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/YY - HH:mm:ss");

        System.out.println(localDateTime.format(dateTimeFormatter));
        System.out.println(dateTimeFormatter.format(localDateTime));

//        LocalDate myDate=LocalDate.now();
//        System.out.println(myDate.format(dateTimeFormatter)); trasnaie


    }
}
