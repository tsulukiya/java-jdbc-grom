package hibernate.lesson2.task1;

import java.util.Arrays;
import java.util.List;

public class Demo {

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

    }
}
