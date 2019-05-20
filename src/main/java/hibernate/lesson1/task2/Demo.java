package hibernate.lesson1.task2;

public class Demo {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        Product product = new Product();
        product.setId(1111);
        product.setName("orange");
        product.setDescription("fruit");
        product.setPrice(100);

        //productRepository.save(product);
        //productRepository.delete(102);
        //productRepository.update(product);
    }
}
