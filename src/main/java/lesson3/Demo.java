package lesson3;

public class Demo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(102, "test111", "test description", 99);
        //productDAO.save(product);
        //System.out.println(productDAO.getProduct());
        //productDAO.delete(997);
        productDAO.update(product);


    }
}
