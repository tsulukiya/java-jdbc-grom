package lesson4.hw1.repository;

import lesson4.hw1.model.Storage;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class StorageRepository extends ShareRepository {
    @Override
    void initStatement(PreparedStatement preparedStatement, Object object) {

        try {
            Storage storage = (Storage) object;

            preparedStatement.setLong(1, storage.getId());
            preparedStatement.setString(2, storage.getFormatsSupported());
            preparedStatement.setString(3, storage.getStorageCountry());
            preparedStatement.setLong(4, storage.getStorageMaxSize());

            int res = preparedStatement.executeUpdate();
            System.out.println("Save was finished with result " + res);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Storage save(Storage storage) {
        insertObjectToDb(storage);
        return storage;
    }

    public Storage delete(long id) {
        return null;
    }

    public Storage update(Storage storage) {
        return null;
    }

    public Storage findById(long id) {
        return null;
    }


}
