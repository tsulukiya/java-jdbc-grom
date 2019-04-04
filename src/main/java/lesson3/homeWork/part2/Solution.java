package lesson3.homeWork.part2;

import java.sql.*;

public class Solution {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.clg2f8ljlc7q.us-east-2.rds.amazonaws.com:1521:ORCL";

    private static final String USER = "main";
    private static final String PASS = "TsulukiyA_123";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS); Statement statement = connection.createStatement()) {

            int response = statement.executeUpdate("CREATE TABLE TEST_SPEED (ID NUMBER, CONSTRAINT TABLE_PK PRIMARY KEY (ID), SOME_STRING NVARCHAR2(100) NOT NULL, SOME_NUMBER NUMBER NOT NULL)");
            System.out.println(response);



        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }

    }
}
