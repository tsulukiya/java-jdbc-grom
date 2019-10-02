package hibernate.lesson2;

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

    public static void main(String[] args) {
        Product product = new Product();
        product.setId(1);
        product.setName("table new!");
        product.setDescription("grey & blue");
        product.setPrice(70);

        //save(product);

        Product product1 = new Product();
        product1.setName("atable new111!");
        product1.setDescription("grey & blue");
        product1.setPrice(70);

        Product product2 = new Product();
        product2.setName("abtable new222!");
        product2.setDescription("grey & blue");
        product2.setPrice(80);

        Product product3 = new Product();
        product3.setName("aatable new333!");
        product3.setDescription("grey & blue");
        product3.setPrice(90);

        List<Product> products = Arrays.asList(product1, product2, product3);
        //saveAll(products);
        //update(product);
        //delete(product);
        //deleteAll(products);
        //updateAll(products);
        //System.out.println(findById(3));
        //System.out.println(findByName("test"));
        //System.out.println(findByContainedName("oy"));
        //System.out.println(findByPrice(100, 20));
        //System.out.println(findByNameSortedAsc("table"));
        //System.out.println(findByNameSortedDesc());
        //System.out.println(findByPriceSortedDesc(100, 20));

    }

    public static void save(Product product) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.save(product);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void update(Product product) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.update(product);
            tr.commit();
            System.out.println("Update is done");
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void delete(Product product) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            session.delete(product);
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void saveAll(List<Product> products) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.save(product);
            }

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void updateAll(List<Product> products) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.update(product);
            }

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void deleteAll(List<Product> products) {
        Session session = null;
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            for (Product product : products) {
                session.delete(product);
            }

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.err.println(e.getMessage());
            if (tr != null)
                tr.rollback();
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
