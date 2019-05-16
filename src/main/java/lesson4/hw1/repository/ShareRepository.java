package lesson4.hw1.repository;

import lesson4.hw1.model.File;
import lesson4.hw1.model.Storage;

import java.sql.*;

public abstract class ShareRepository {
    private static final String DB_URL = "jdbc:oracle:thin:@gromcode-lessons.clg2f8ljlc7q.us-east-2.rds.amazonaws.com:1521:ORCL";
    private static final String USER = "main";
    private static final String PASS = "TsulukiyA_123";


    public void checkStorageFormatSupported(Storage storage, File file, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT FORMAT_SUPPORTED FROM STORAGE WHERE ID = ?")) {

            connection.setAutoCommit(false);

            preparedStatement.setLong(1, storage.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            String formatSupportedStorage = null;

            while (resultSet.next()) {
                formatSupportedStorage = resultSet.getString(1);
            }

            if (formatSupportedStorage != null) {
                String[] format = formatSupportedStorage.split(",");
                int count = 0;

                for (String s : format) {
                    if (s.equals(file.getFormat())) {
                        count++;
                        System.out.println(count);
                    }
                }

                if (count == 0) {
                    throw new SQLException("File format with ID = " + file.getId() + " is not supported this Storage");
                }
            }
        } catch (SQLException e) {
            System.out.println("Format file is not supported this storage");
            connection.rollback();
            throw e;
        }
    }


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
