package hibernate.lesson4.repository;


import hibernate.lesson4.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HotelRepository {
    private static SessionFactory sessionFactory;
    ShareRepository shareRepository = new ShareRepository();
    private static String sqlHotelFindById = "from Hotel where id = :code";
    private static String sqlHotelFindByName = "from Hotel where name = :code";
    private static String sqlHotelFindByCity = "from Hotel where city = :code";

    public Hotel save(Hotel hotel) {
        return (Hotel) shareRepository.save(hotel);
    }

    public Hotel update(Hotel hotel) {
        return (Hotel) shareRepository.update(hotel);
    }

    public Hotel delete(long id) {
        return (Hotel) shareRepository.delete(id, sqlHotelFindById);
    }

    public Hotel findById(long id) {
        return (Hotel) shareRepository.findById(id, sqlHotelFindById);
    }

    public Hotel findHotelByName(String name) {
        Session session = null;
        Transaction tr;
        Hotel hotel = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Query query = session.createQuery(sqlHotelFindByName);
            query.setParameter("code", name);
            for (Object o : query.list()) {
                hotel = (Hotel) o;
            }
            System.out.println("Method findByName is done...");
            tr.commit();
            return hotel;

        } catch (HibernateException e) {
            System.err.println("FindByName is failed");
            System.err.println(e.getMessage());
            throw e;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Hotel findHotelByCity(String city) {
        Session session = null;
        Transaction tr;
        Hotel hotel = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Query query = session.createQuery(sqlHotelFindByCity);
            query.setParameter("code", city);
            for (Object o : query.list()) {
                hotel = (Hotel) o;
            }
            System.out.println("Method findByCity is done...");
            tr.commit();
            return hotel;

        } catch (HibernateException e) {
            System.err.println("FindByCity is failed");
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