package lesson3.homeWork.part1;

import lesson3.classWork.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.clg2f8ljlc7q.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "TsulukiyA_123";

    public List<Product> findProductsByPrice(int price, int delta) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE PRICE > ? AND PRICE < ?");
            preparedStatement.setInt(1, price - delta);
            preparedStatement.setInt(2, price + delta);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();

            while (resultSet.next()) {
                productList.add(new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4)));
            }

            return productList;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> findProductByName(String word) {

        validateWord(word);

        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PRODUCT WHERE NAME LIKE ?");
            preparedStatement.setString(1, "%" + word + "%");

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();

            while (resultSet.next()) {
                productList.add(new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4)));
            }
            return productList;

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> findProductByEmptyDescription() {
        try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCT WHERE DESCRIPTION IS NULL");
            List<Product> productList = new ArrayList<>();

            while (resultSet.next()) {
                productList.add(new Product(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4)));
            }

            return productList;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private void validateWord(String word) {
        char[] array = word.toCharArray();
        if (array.length < 3)
            throw new IllegalArgumentException("Word - " + word + " is not correct");
        for (char c : array) {
            if (c == ' ')
                throw new IllegalArgumentException("Word - " + word + " have Space");
            if (Character.isSpaceChar(c))
                throw new IllegalArgumentException("Word - " + word + " have SpaceChar");
        }
    }
}
