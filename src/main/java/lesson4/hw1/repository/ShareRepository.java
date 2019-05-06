package lesson4.hw1.repository;

import lesson4.cw.Product;
import lesson4.hw1.model.File;
import lesson4.hw1.model.Storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ShareRepository<T> {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.clg2f8ljlc7q.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "TsulukiyA_123";


    public T insertObjectToDb(T t) {

        try (Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement(sqlQueryInsertToDb())) {

            connection.setAutoCommit(true);

            initStatement(preparedStatement, t);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return t;
    }

    private String sqlQueryInsertToDb() {
        return "INSERT INTO STORAGE VALUES (?, ?, ?, ?)";
    }

    abstract void initStatement(PreparedStatement preparedStatement, T t);


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
