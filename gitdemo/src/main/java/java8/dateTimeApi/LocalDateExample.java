package java8.dateTimeApi;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

public class LocalDateExample {
    public static void main(String[] args) {
        // of() with Month enum or number, index of month ->  LocalDateExample.of(2015, 1, 1)
        // now() and parse() -> parse(“9999-99-99”)  -> DateTimeException
        LocalDate today = LocalDate.of(2018, 9, 21);
        LocalDate tommorow = LocalDate.of(2018, Month.SEPTEMBER, 22);
        LocalDate now=LocalDate.now();
        System.out.println(today);
        System.out.println(now);
        LocalDate parser=LocalDate.parse("9999-09-08");
        System.out.println(parser);






        // plus, minus ChronoUnit


        LocalDate correctDate=now.minusYears(21).minusMonths(1).minusDays(14);
        System.out.println(correctDate);
        LocalDate chrono= LocalDate.now().minus(10, ChronoUnit.DAYS);
        System.out.println(chrono);

        // getDayOfMonth(), getDayOfWeek(), getDayOfYear(), getMonth(), getMonthValue(), getYear()

        System.out.println(now.getMonth());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getYear());
        // isBefore(), isAfter(), minusXX(), plusXX() - days, months, weeks, years, withXX()
        System.out.println(now.isBefore(tommorow));
    }
}
