package jdbc.lesson1.homeWork;

import java.sql.*;

public class JDBCHomeWork {
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.clg2f8ljlc7q.us-east-2.rds.amazonaws.com:1521:ORCL";

    private static final String USER = "main";
    private static final String PASS = "TsulukiyA_123";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {

            Class.forName(JDBC_DRIVER);

            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM CUSTOMER")) {
                while (resultSet.next()) {
                    System.out.println("Object found");
                }
            }

        } catch (Exception e) {
            System.err.println("Something went wrong");
        }
    }
}
