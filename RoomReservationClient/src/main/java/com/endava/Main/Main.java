package com.endava.Main;


import com.endava.HotelService;
import com.endava.HotelServiceService;
import com.endava.StringArray;

public class Main {
    public static void main(String[] args) {
        HotelService service= new HotelServiceService().getPort(HotelService.class);
        StringArray hotels=service.getHotels("France");
        for(String hotelName:hotels.getItem())
            System.out.println(hotelName);
    }
}
