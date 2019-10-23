package hibernate.lesson4.repository;


import hibernate.lesson4.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static SessionFactory sessionFactory;
    ShareRepository shareRepository = new ShareRepository();
    private static String sqlUserFindById = "from User where id = :code";
    private static String sqlUserLogin = "from User where name = :code and password =:code1";

    public User save(User user) {
        return (User) shareRepository.save(user);
    }

    public User update(User user) {
        return (User) shareRepository.update(user);
    }

    public User delete(long id) {
        return (User) shareRepository.delete(id, sqlUserFindById);
    }

    public User findById(long id) {
        return (User) shareRepository.findById(id, sqlUserFindById);
    }

    public User registerUser(User user) {
        if (shareRepository.findById(user.getId(), sqlUserFindById) != null) {
            save(user);
            return user;
        }
        return null;
    }

    public void login(String userName, String password) {
        Session session = null;
        Transaction tr;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            Query query = session.createQuery(sqlUserLogin);

            query.setParameter("code", userName);
            query.setParameter("code1", password);

            if (query.list()!=null)

                System.out.println("User: " + userName + "is login...");
            tr.commit();

        } catch (HibernateException e) {
            System.err.println("User: " + userName + "is not login...");
            System.err.println(e.getMessage());
            throw e;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void logout() {
        System.out.println("User is logout");
    }

    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }


}
