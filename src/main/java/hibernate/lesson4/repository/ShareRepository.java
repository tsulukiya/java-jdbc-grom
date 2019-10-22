package hibernate.lesson4.repository;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ShareRepository<T> {
    private static SessionFactory sessionFactory;

    public T save(T t) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.save(t);
            tr.commit();
            System.out.println("Save in DB is done" + t.toString());
            return t;
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
        return null;
    }


    public T update(T t) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(t);
            tr.commit();
            System.out.println("Update is done");
            return t;
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
        return null;
    }

    public T delete(long id, String sqlQuery) {
        Session session = null;
        Transaction tr = null;
        T t = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Query query = session.createQuery(sqlQuery);
            query.setParameter("code", id);
            for (Object o : query.list()) {
                t = (T) o;
            }
            session.delete(t);
            tr.commit();
            System.out.println("Delete is done...");
        } catch (HibernateException e) {
            System.err.println("Delete is failed");
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
        return null;
    }

    public T findById(long id, String sqlQuery) {
        Session session = null;
        Transaction tr;
        T t = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            Query query = session.createQuery(sqlQuery);
            query.setParameter("code", id);
            for (Object o : query.list()) {
                t = (T) o;
            }
            System.out.println("Method findById is done...");
            tr.commit();
            return t;

        } catch (HibernateException e) {
            System.err.println("FindById is failed");
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
