package hibernate.lesson2.task2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class ProductDao {

    private static SessionFactory sessionFactory;


    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public static List<Product> findById(long id) {
        Session session = null;
        List<Product> products = null;
        try {
            session = createSessionFactory().openSession();
            Query query = session.createQuery("from Product where id = :code");
            query.setParameter("code", id);
            products = query.list();

        } catch (HibernateException e) {
            System.err.println("FindById is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    public static List<Product> findByName(String name) {
        Session session = null;
        List<Product> products = null;
        try {
            session = createSessionFactory().openSession();
            Query query = session.createQuery("from Product where name = :code");
            query.setParameter("code", name);
            products = query.list();

        } catch (HibernateException e) {
            System.err.println("FindById is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    public static List<Product> findByContainedName(String name) {
        Session session = null;
        List<Product> products = null;
        try {
            session = createSessionFactory().openSession();
            Query query = session.createQuery("from Product where name like :code");
            query.setParameter("code", "%" + name + "%");
            products = query.list();

        } catch (HibernateException e) {
            System.err.println("FindById is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    public static List<Product> findByPrice(int price, int delta) {
        Session session = null;
        List<Product> products = null;
        try {
            session = createSessionFactory().openSession();
            Query query = session.createQuery("from Product where price between :priceMin and :priceMax");
            query.setParameter("priceMin", price - delta);
            query.setParameter("priceMax", price + delta);
            products = query.list();

        } catch (HibernateException e) {
            System.err.println("FindById is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    public static List<Product> findByNameSortedAsc(String name) {
        Session session = null;
        List<Product> products = null;
        try {
            session = createSessionFactory().openSession();
            Query query = session.createQuery("from Product where name = :code order by name asc");
            query.setParameter("code", name);

            products = query.list();

        } catch (HibernateException e) {
            System.err.println("FindById is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }

    public static List<Product> findByNameSortedDesc() {
        Session session = null;
        List<Product> products = null;
        try {
            session = createSessionFactory().openSession();
            Query query = session.createQuery("from Product order by name desc");

            products = query.list();

        } catch (HibernateException e) {
            System.err.println("FindById is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;

    }

    public static List<Product> findByPriceSortedDesc(int price, int delta) {
        Session session = null;
        List<Product> products = null;
        try {
            session = createSessionFactory().openSession();
            Query query = session.createQuery("from Product where price between :priceMin and :priceMax order by price desc");
            query.setParameter("priceMin", price - delta);
            query.setParameter("priceMax", price + delta);
            products = query.list();

        } catch (HibernateException e) {
            System.err.println("FindById is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return products;
    }
}
