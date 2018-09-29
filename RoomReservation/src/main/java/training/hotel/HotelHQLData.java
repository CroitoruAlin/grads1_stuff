package training.hotel;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HotelHQLData implements HotelData {
    private final SessionFactory sessionFactory;

    public HotelHQLData(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Hotel> getHotelsWithAirConditioning() {
        return sessionFactory.openSession().createQuery("select " +
                "h.id from Hotel h join h.rooms r  where  r.typeId=1 group by h.id").list();
    }

    @Override
    public List<Hotel> findAll() {

        Query<Hotel> query = sessionFactory.openSession().createQuery("select h from Hotel h join fetch h.address a");
        return query.list();

    }
}
