package lesson4.hw1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ShareRepository {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.clg2f8ljlc7q.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "TsulukiyA_123";




    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
