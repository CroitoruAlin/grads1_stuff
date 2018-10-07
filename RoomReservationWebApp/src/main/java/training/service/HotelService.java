package training.service;

import training.SessionFactoryProvider;
import training.building.Room;
import training.building.Room1;
import training.building.RoomTypes;
import training.hotel.HQLHotelData;
import training.hotel.Hotel;
import training.hotel.HotelData;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HotelService {
    private HotelData hotelData;
    private SessionFactoryProvider sessionFactoryProvider=new SessionFactoryProvider("hibernate.cfg.xml");


    public HotelService() {

        hotelData=new HQLHotelData(sessionFactoryProvider);

    }
    @WebMethod(operationName = "getHotels")
    public String[] getListOfHotel(String country)
    {
        sessionFactoryProvider.getSession().beginTransaction();
        List<String> listHotels=hotelData.findAllFromCountry(country);
        String[] aux= new String[listHotels.size()];
        aux=listHotels.toArray(aux);
        return aux;
    }
    @WebMethod(operationName = "getRoom")
    public Room1 getRoom(String roomName)
    {
        return new Room1(roomName,new RoomTypes("Apartment"),2);
    }

    @Override
    protected void finalize() throws Throwable {
        sessionFactoryProvider.shutdown();
    }
}
