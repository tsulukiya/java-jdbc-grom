package hibernate.lesson3;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.collection.internal.PersistentList;
import org.hibernate.collection.internal.PersistentSet;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RoomDao {

    private static SessionFactory sessionFactory;
    private static String sqlRoomFindById = "from Room where id = :code";


    public void save(Room room) throws HibernateException {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.save(room);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
                throw e;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(Room room) throws HibernateException {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(room);
            tr.commit();
            System.out.println("Update is done");
        } catch (HibernateException e) {
            System.err.println("Update is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
                throw e;
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Room room) throws HibernateException {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(room);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.err.println(e.getMessage());
            if (tr != null) {
                tr.rollback();
                throw e;
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Room findById(long id) throws HibernateException {
        Session session = null;
        List<Room> roomList;
        Room room = new Room();
        Transaction tr;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            Query query = session.createQuery(sqlRoomFindById);
            query.setParameter("code", id);
            roomList =  query.list();

            for (Room room1 : roomList) {

               room.setId(room1.getId());
               room.setNumberOfGuests(room1.getNumberOfGuests());
               room.setBreakfastIncluded(room1.getBreakfastIncluded());
               room.setDateAvailableFrom(room1.getDateAvailableFrom());
               room.setPetsAllowed(room1.getPetsAllowed());
               room.setPrice(room1.getPrice());
            }

            tr.commit();

        } catch (HibernateException e) {
            System.err.println("FindById is failed");
            System.err.println(e.getMessage());
            throw e;

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return room;
    }


    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
