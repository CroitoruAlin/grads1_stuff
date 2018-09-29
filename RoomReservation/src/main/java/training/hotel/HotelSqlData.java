package training.hotel;

import training.hotel.Hotel;
import training.hotel.HotelData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelSqlData implements HotelData {
    private final String connectionString;

    public HotelSqlData(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    public List<Hotel> getHotelsWithAirConditioning() {


        try (
                Connection connection= DriverManager.getConnection(connectionString,"user","")
        ){
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select  h.* from \n" +
                    "hotels h join rooms r on(r.hotel_id=h.id) \n" +
                    "join room_amenities ra on(ra.room_id=r.id) \n" +
                    "join amenities a on (a.id=ra.amenity_id)\n" +
                    "where upper(a.name)=\"ROOM SERVICE\" \n" +
                    "group by h.id;");
            List<Hotel> listHotels=new ArrayList<>();
            while(resultSet.next())
            {
                Hotel hotel=new Hotel();
                hotel.setId(resultSet.getLong("id"));
                hotel.setName(resultSet.getString("name"));
                hotel.setStars(resultSet.getInt("stars"));
                hotel.setAddressId(resultSet.getLong("address_id"));
                listHotels.add(hotel);
            }
            return listHotels;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Hotel> findAll() {
        return null;
    }
}
