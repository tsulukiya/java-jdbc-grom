package hibernate.lesson4.repository;


import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Order;
import hibernate.lesson4.model.Room;
import hibernate.lesson4.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomRepository {
    private static SessionFactory sessionFactory;
    private static ShareRepository shareRepository = new ShareRepository();
    private static OrderRepository orderRepository = new OrderRepository();
    private static HotelRepository hotelRepository = new HotelRepository();
    private static UserRepository userRepository = new UserRepository();
    private static String sqlCancelReservation = "delete Order where userOrdered =:code and room =:code1";
    private static String sqlRoomFindById = "from Room where id = :code";
    private static String sqlBookRoom = "from Room where id = :code";
    private static String sqlRoomFindByFilter = "from Room where numberOfGuests = :code " +
            "and price =:code1 and breakfastIncluded =:code2 and petsAllowed =:code3 " +
            "and dateAvailableFrom <=:code4 and hotel.country =:code5 and hotel.city =:code6";

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

            Query query = session.createQuery(sqlRoomFindByFilter);

            query.setParameter("code", filter.getNumberOfGuests());
            query.setParameter("code1", filter.getPrice());
            query.setParameter("code2", filter.getBreakfastIncluded());
            query.setParameter("code3", filter.getPetsAllowed());
            query.setParameter("code4", filter.getDateAvailableFrom());
            query.setParameter("code5", filter.getCountry());
            query.setParameter("code6", filter.getCity());

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

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) {
        Session session = null;
        Transaction tr;
        Order order = new Order(new User(userId), new Room(roomId), dateFrom, dateTo);
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            orderRepository.save(order);
            System.out.println("Book Room with id: " + roomId + " is done...");
            tr.commit();

        } catch (HibernateException e) {
            System.err.println("Book Room with id: " + roomId + " is failed...");
            System.err.println(e.getMessage());
            throw e;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void cancelReservation(long roomId, long userId) {
        Session session = null;
        Transaction tr;
        List<Room> roomList = new ArrayList<>();
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            Query query = session.createQuery(sqlCancelReservation);

            query.setParameter("code", userId);
            query.setParameter("code1", roomId);
            query.executeUpdate();
            System.out.println("Reservation is cancelled.");
            tr.commit();

        } catch (HibernateException e) {
            System.err.println("Cancel reservation is failed");
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

