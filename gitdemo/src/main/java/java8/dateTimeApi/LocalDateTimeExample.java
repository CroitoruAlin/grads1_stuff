package java8.dateTimeApi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        // of, now

        LocalDateTime now= LocalDateTime.now();
        System.out.println(now);

        LocalDateTime localDateTime=LocalDateTime.of(LocalDate.parse("2012-02-12"),LocalTime.parse("12:20:21"));
        System.out.println(localDateTime);

        // atTime() to convert LocalDate to LocalDateTime -> overloaded
        LocalDateTime atTime=LocalDate.now().atTime(10,21);
        System.out.println(atTime);
        LocalDateTime atDate=LocalTime.now().atDate(LocalDate.parse("2012-09-12"));

        System.out.println(atDate);
        //atDate() to convert LocalTime to LocalDateTime

    }
}
