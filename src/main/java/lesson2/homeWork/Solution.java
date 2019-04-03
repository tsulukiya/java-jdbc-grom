package lesson2.homeWork;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.clg2f8ljlc7q.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "TsulukiyA_123";
    

    private static void saveProduct() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {
            int response = statement.executeUpdate("INSERT INTO PRODUCT VALUES (999, 'toy111', 'for children', 60)");
            System.out.println(response);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();

        }
    }

    private static void deleteProducts() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {
            int response = statement.executeUpdate("DELETE FROM PRODUCT WHERE NAME != 'toy'");
            System.out.println(response);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();

        }
    }

    private static void deleteProductsByPrice() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {
            int response = statement.executeUpdate("DELETE FROM PRODUCT WHERE PRICE < 100");
            System.out.println(response);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();

        }
    }

    private static Set<Product> getAllProducts() {
        Set<Product> productSet = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT");
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                int price = resultSet.getInt(4);
                productSet.add(new Product(id, name, description, price));

            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();

        }
        return productSet;
    }

    private static Set<Product> getProductsByPrice() {
        Set<Product> productSet = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT WHERE PRICE <= 100 ");
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                int price = resultSet.getInt(4);
                productSet.add(new Product(id, name, description, price));

            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();

        }
        return productSet;
    }

    private static Set<Product> getProductsByDescription() {
        Set<Product> productSet = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT");
            while (resultSet.next() && resultSet.getString(3).toCharArray().length > 50) {
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                int price = resultSet.getInt(4);
                productSet.add(new Product(id, name, description, price));
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();

        }
        return productSet;
    }
}
