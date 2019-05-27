package hibernate.lesson1.task1;

import org.hibernate.Session;

public class Demo {
    public static void main(String[] args) {
        Session session = new HibernateUtils().createSessionFactory().openSession();

        session.getTransaction().begin();

        Product product = new Product();
        product.setId(9999);
        product.setName("table www");
        product.setDescription("grey & blue");
        product.setPrice(70);

        session.save(product);

        session.getTransaction().commit();

        System.out.println("Done");

        session.close();
    }
}
