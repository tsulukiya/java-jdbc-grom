package hibernate.lesson4.repository;


import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomRepository {
    private static SessionFactory sessionFactory;
    private ShareRepository shareRepository = new ShareRepository();
    private HotelRepository hotelRepository = new HotelRepository();
    private static String sqlRoomFindById = "from Room where id = :code";
    private static String sqlRoomFindByFilter = "from Room where numberOfGuests = :code " +
            "and price =:code1 and inBreakfastIncluded =:code2 and petsAllowed =:code3" +
            "and DATE_AVAILABLE_FROM <=:code4";

    public Room save(Room room) {
        room.setHotel(hotelRepository.findById(room.getHotel().getId()));
        return (Room) shareRepository.save(room);
    }

    public Room update(Room room) {
        room.setHotel(hotelRepository.findById(room.getHotel().getId()));
        return (Room) shareRepository.update(room);
    }

    public Room delete(long id) {
        return (Room) shareRepository.delete(id, sqlRoomFindById);
    }

    public Room findById(long id) {
        return (Room) shareRepository.findById(id, sqlRoomFindById);
    }

    public List<Room> findRooms(Filter filter) {
        Session session = null;
        Transaction tr;
        List<Room> roomList = new ArrayList<>();
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Query query = session.createQuery(sqlRoomFindByFilter);

            query.setParameter("code", filter.getNumberOfGuests());
            query.setParameter("code1", filter.getPrice());
            query.setParameter("code2", filter.getBreakfastIncluded());
            query.setParameter("code3", filter.getPetsAllowed());
            query.setParameter("code3", simpleDateFormat.format(filter.getDateAvailableFrom()));

            for (Object o : query.list()) {
                roomList.add((Room) o);
            }
            System.out.println("Method findRooms is done...");
            tr.commit();
            return roomList;

        } catch (HibernateException e) {
            System.err.println("FindRooms is failed");
            System.err.println(e.getMessage());
            throw e;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

}

