package training.hotel;

import training.hotel.Hotel;

import java.util.List;

public interface HotelData  {
    List<Hotel> getHotelsWithAirConditioning();
    List<Hotel> findAll();
}
