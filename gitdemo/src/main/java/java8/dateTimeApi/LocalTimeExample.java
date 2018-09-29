package java8.dateTimeApi;

import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        // of() , now() and parse()// daca valorile limita sunt depasite sa va arunca DataTimeException pentru of, iar pt parse returneaza DateTimeFormatter

        LocalTime localTime= LocalTime.now();
        LocalTime localTime1=LocalTime.of(10,8,32);
        LocalTime timeParse=LocalTime.parse("10:11:01.123");
        System.out.println(localTime);
        System.out.println(timeParse);

        // getHour(), getMinute(), getSecond(), getNano() -> singular, not plural;
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        // isAfter(), isBefore(), minusXX(), plusXX() - hours, minutes, seconds, nanos
        localTime.isBefore(timeParse);
        //  withHour(), withMinute(), withSecond(), withNano()
        LocalTime localTimeWithHour=localTime.withHour(9);
        System.out.println(localTimeWithHour);
    }
}
