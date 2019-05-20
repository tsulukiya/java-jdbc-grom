package hibernate.lesson1.task2;


import org.hibernate.Session;

public class ProductRepository {
    Session session = new HibernateUtils().createSessionFactory().openSession();

    public void save(Product product) {
        session.getTransaction().begin();
        session.save(product);
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }

    public void delete(long id) {
        session.getTransaction().begin();
        session.delete(new Product(id));
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }

    public void update(Product product) {
        session.getTransaction().begin();
        session.update(product);
        session.getTransaction().commit();
        System.out.println("Done");
        session.close();
    }
}
