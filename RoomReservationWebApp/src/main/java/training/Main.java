package training;

import training.hotel.Hotel;
import training.hotel.Hotels;

public class Main {
    public static void main(String[] args) {
        Hotels hotels= Hotels.getInstance();
        System.out.println(hotels.getHotels());
    }
}
