package lesson4.hw1.repository;

import lesson4.hw1.model.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StorageRepository extends ShareRepository {

    public Storage save(Storage storage) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STORAGE VALUES(?, ?, ?, ?)");
            preparedStatement.setLong(1, storage.getId());
            preparedStatement.setString(2, storage.getFormatsSupported());
            preparedStatement.setString(3, storage.getStorageCountry());
            preparedStatement.setLong(4, storage.getStorageMaxSize());

            int res = preparedStatement.executeUpdate();

            System.out.println("Save object to table STORAGE was finished with result " + res);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return storage;
    }

    public Storage delete(long id) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM STORAGE WHERE ID = ?");
            preparedStatement.setLong(1, id);

            int res = preparedStatement.executeUpdate();

            System.out.println("delete was finished with result " + res);


        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public Storage update(Storage storage) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE STORAGE SET ID=?, FORMAT_SUPPORTED=?," +
                    " STORAGE_COUNTRY=?, STORAGE_MAX_SIZE=? WHERE ID = ?");
            preparedStatement.setLong(1, storage.getId());
            preparedStatement.setString(2, storage.getFormatsSupported());
            preparedStatement.setString(3, storage.getStorageCountry());
            preparedStatement.setLong(4, storage.getStorageMaxSize());
            preparedStatement.setLong(5, storage.getId());

            int res = preparedStatement.executeUpdate();

            System.out.println("update was finished with result " + res);

            return storage;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public Storage findById(long id) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STORAGE WHERE ID = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Storage(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getLong(4));
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }


}
