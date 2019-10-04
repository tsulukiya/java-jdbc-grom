package hibernate.lesson2.task3;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private static SessionFactory sessionFactory;


    public static SessionFactory createSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public List<Product> findById(long id) {
        Session session = null;
        List<Object[]> products;
        List<Product> productList = new ArrayList<>();
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM PRODUCT WHERE ID = :id");
            products = sqlQuery.setLong("id", id).list();

            if (products != null)

                for (Object[] product : products) {
                    Product product1 = new Product();
                    product1.setId(Long.parseLong(product[0].toString()));
                    product1.setName(product[1].toString());
                    product1.setDescription(product[2].toString());
                    product1.setPrice(Integer.parseInt(product[3].toString()));
                    productList.add(product1);
                }

            tr.commit();

        } catch (HibernateException e) {
            tr.rollback();
            System.err.println("FindById is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    public List<Product> findByName(String name) {
        Session session = null;
        List<Object[]> products;
        List<Product> productList = new ArrayList<>();
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM PRODUCT WHERE NAME = :name");
            products = sqlQuery.setString("name", name).list();
            if (products != null)
                for (Object[] product : products) {
                    Product product1 = new Product();
                    product1.setId(Long.parseLong(product[0].toString()));
                    product1.setName(product[1].toString());
                    product1.setDescription(product[2].toString());
                    product1.setPrice(Integer.parseInt(product[3].toString()));
                    productList.add(product1);
                }
            tr.commit();
        } catch (HibernateException e) {
            tr.rollback();
            System.err.println("FindByName is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    public List<Product> findByContainedName(String name) {
        Session session = null;
        List<Object[]> products;
        List<Product> productList = new ArrayList<>();
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM PRODUCT WHERE NAME LIKE :name");
            sqlQuery.setString("name",  "%"+name+"%" );
            products = sqlQuery.list();

            if (products != null)
                for (Object[] product : products) {
                    Product product1 = new Product();
                    product1.setId(Long.parseLong(product[0].toString()));
                    product1.setName(product[1].toString());
                    product1.setDescription(product[2].toString());
                    product1.setPrice(Integer.parseInt(product[3].toString()));
                    productList.add(product1);
                }
            tr.commit();



        } catch (HibernateException e) {
            tr.rollback();
            System.err.println("FindByContainedName is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    public List<Product> findByPrice(int price, int delta) {
        Session session = null;
        List<Object[]> products;
        List<Product> productList = new ArrayList<>();
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE PRICE BETWEEN :priceMin AND :priceMax");
            query.setInteger("priceMin", price - delta);
            query.setInteger("priceMax", price + delta);
            products = query.list();

            if (products != null)
                for (Object[] product : products) {
                    Product product1 = new Product();
                    product1.setId(Long.parseLong(product[0].toString()));
                    product1.setName(product[1].toString());
                    product1.setDescription(product[2].toString());
                    product1.setPrice(Integer.parseInt(product[3].toString()));
                    productList.add(product1);
                }
            tr.commit();


        } catch (HibernateException e) {
            tr.rollback();
            System.err.println("FindByPrice is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    public List<Product> findByNameSortedAsc(String name) {
        Session session = null;
        List<Object[]> products;
        List<Product> productList = new ArrayList<>();
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE NAME = :name ORDER BY NAME ASC");
            query.setString("name", name);
            products = query.list();

            if (products != null)
                for (Object[] product : products) {
                    Product product1 = new Product();
                    product1.setId(Long.parseLong(product[0].toString()));
                    product1.setName(product[1].toString());
                    product1.setDescription(product[2].toString());
                    product1.setPrice(Integer.parseInt(product[3].toString()));
                    productList.add(product1);
                }
            tr.commit();

        } catch (HibernateException e) {
            tr.rollback();
            System.err.println("FindByNameSortedAsc is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    public List<Product> findByNameSortedDesc(String name) {
        Session session = null;
        List<Object[]> products;
        List<Product> productList = new ArrayList<>();
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE NAME = :name ORDER BY NAME DESC");
            query.setString("name", name);
            products = query.list();

            if (products != null)
                for (Object[] product : products) {
                    Product product1 = new Product();
                    product1.setId(Long.parseLong(product[0].toString()));
                    product1.setName(product[1].toString());
                    product1.setDescription(product[2].toString());
                    product1.setPrice(Integer.parseInt(product[3].toString()));
                    productList.add(product1);
                }
            tr.commit();

        } catch (HibernateException e) {
            tr.rollback();
            System.err.println("FindByNameSortedAsc is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    public List<Product> findByPriceSortedDesc(int price, int delta) {
        Session session = null;
        List<Object[]> products;
        List<Product> productList = new ArrayList<>();
        Transaction tr = null;
        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();
            SQLQuery query = session.createSQLQuery("SELECT * FROM PRODUCT WHERE PRICE BETWEEN :priceMin AND :priceMax ORDER BY " +
                    "PRICE DESC");
            query.setInteger("priceMin", price - delta);
            query.setInteger("priceMax", price + delta);
            products = query.list();

            if (products != null)
                for (Object[] product : products) {
                    Product product1 = new Product();
                    product1.setId(Long.parseLong(product[0].toString()));
                    product1.setName(product[1].toString());
                    product1.setDescription(product[2].toString());
                    product1.setPrice(Integer.parseInt(product[3].toString()));
                    productList.add(product1);
                }
            tr.commit();


        } catch (HibernateException e) {
            tr.rollback();
            System.err.println("FindByPrice is failed");
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }
}
