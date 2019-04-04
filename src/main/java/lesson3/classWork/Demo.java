package lesson3.classWork;

import lesson3.homeWork.part1.Solution;

public class Demo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        Solution solution = new Solution();
        Product product = new Product(102, "test111", "test description", 99);
        //productDAO.save(product);
        //System.out.println(productDAO.getProduct());
        //productDAO.delete(997);
        //productDAO.update(product);
        //System.out.println(solution.findProductsByPrice(40, 100));
        //System.out.println(solution.findProductByName("111"));
        System.out.println(solution.findProductByEmptyDescription());


    }
}
