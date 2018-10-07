package training.hotel;

import training.SessionFactoryProvider;

import java.util.ArrayList;
import java.util.List;

public class Hotels {
    private List<Hotel> hotelList;
    private static Hotels hotels=null;
    private SessionFactoryProvider sessionFactoryProvider;

    private Hotels()
    {
         sessionFactoryProvider = new SessionFactoryProvider("hibernate.cfg.xml");
        sessionFactoryProvider.getSession().beginTransaction();
        hotelList=new HQLHotelData(sessionFactoryProvider).findAll();


    }
    public static Hotels getInstance()
    {

        if(hotels==null)
            hotels=new Hotels();
        return hotels;
    }
    public List<Hotel> getHotels()
    {
        return hotels.hotelList;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        sessionFactoryProvider.shutdown();
    }
}
