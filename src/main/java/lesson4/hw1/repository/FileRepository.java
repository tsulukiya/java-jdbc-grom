package lesson4.hw1.repository;

import lesson4.hw1.model.File;
import lesson4.hw1.model.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FileRepository extends ShareRepository {


    public File put(Storage storage, File file) {
        return null;
    }

    public List<File> putAll(Storage storage, List<File> files) {
        return null;
    }

    public File delete(Storage storage, File file) {
        return null;
    }

    public List<File> transferAll(Storage storageFrom, Storage storageTo) {
        return null;
    }

    public File transferFile(Storage storageFrom, Storage storageTo, long id) {
        return null;
    }

    public File save(File file) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FILE_S VALUES(?, ?, ?, ?, ?)");
            preparedStatement.setLong(1, file.getId());
            preparedStatement.setString(2, file.getName());
            preparedStatement.setString(3, file.getFormat());
            preparedStatement.setLong(4, file.getSize());
            if (file.getStorage() != null) {
                preparedStatement.setLong(5, file.getStorage().getId());
            } else {
                preparedStatement.setObject(5, file.getStorage());
            }

            int res = preparedStatement.executeUpdate();

            System.out.println("Save object to table FILE was finished with result " + res);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return file;
    }

    public File delete(long id) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FILE_S WHERE ID = ?");
            preparedStatement.setLong(1, id);

            int res = preparedStatement.executeUpdate();

            System.out.println("Delete File with ID = " + id + " was finished with result " + res);


        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public File update(File file) {
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE FILE_S SET ID=?, NAME=?," +
                    " FORMAT=?, SIZE_FILE=?, STORAGE=? WHERE ID = ?");
            preparedStatement.setLong(1, file.getId());
            preparedStatement.setString(2, file.getName());
            preparedStatement.setString(3, file.getFormat());
            preparedStatement.setLong(4, file.getSize());
            if (file.getStorage() != null) {
                preparedStatement.setLong(5, file.getStorage().getId());
            } else {
                preparedStatement.setObject(5, file.getStorage());
            }
            preparedStatement.setLong(6, file.getId());

            int res = preparedStatement.executeUpdate();

            System.out.println("update File with ID = " + file.getId() + " was finished with result " + res);

            return file;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public File findById(long id) {
        return null;
    }


}
