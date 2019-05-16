package lesson4.hw1.repository;

import lesson4.hw1.model.File;
import lesson4.hw1.model.Storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileRepository extends ShareRepository {


    public File put(Storage storage, File file) {
        try (Connection connection = getConnection()) {

            checkStorageFormatSupported(storage, file, connection);
            addFileToStorage(storage, file, connection);

            return file;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();

        }
        return null;
    }

    public List<File> putAll(Storage storage, List<File> files) {
        try (Connection connection = getConnection()) {
            for (File file : files) {
                checkStorageFormatSupported(storage, file, connection);
            }
            addListToStorage(storage, files, connection);

            return files;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }


    private void addListToStorage(Storage storage, List<File> files, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE FILE_S SET STORAGE=? WHERE ID = ?")) {

            connection.setAutoCommit(false);

            for (File file : files) {
                checkStorageSize(storage, file.getSize(), connection);
                preparedStatement.setLong(1, storage.getId());
                preparedStatement.setLong(2, file.getId());

                int res = preparedStatement.executeUpdate();
                System.out.println("Save was finished with result " + res);
            }
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    private void addFileToStorage(Storage storage, File file, Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE FILE_S SET STORAGE=? WHERE ID = ?")) {

            connection.setAutoCommit(false);


            checkStorageSize(storage, file.getSize(), connection);

            preparedStatement.setLong(1, storage.getId());
            preparedStatement.setLong(2, file.getId());

            int res = preparedStatement.executeUpdate();

            System.out.println("File with ID = " + file.getId() + " was  add to storage with result " + res);

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        }
    }

    private List<File> extractFileFromStorage(Storage storageFrom, Storage storageTo, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FILE_S WHERE STORAGE=?")) {
            preparedStatement.setLong(1, storageFrom.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            List<File> fileList = new ArrayList<>();

            while (resultSet.next()) {
                fileList.add(new File(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getLong(4), new Storage(storageTo.getId())));
                System.out.println(fileList);
            }


            return fileList;
        } catch (SQLException e) {
            System.err.println("Method extractFileFromStorage is wrong");
        }
        return null;
    }


    public File delete(Storage storage, File file) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement("UPDATE FILE_S SET STORAGE = NULL WHERE ID=?")) {
            preparedStatement.setLong(1, file.getId());
            int res = preparedStatement.executeUpdate();
            System.out.println("File with ID= " + file.getId() + "delete from Storage with ID = " + storage.getId() +
                    "with result = " + res);

        } catch (SQLException e) {
            System.err.println("Method delete file from storage is wrong...");

        }
        return null;
    }

    public List<File> transferAll(Storage storageFrom, Storage storageTo) {
        try (Connection connection = getConnection()) {
            List<File> fileList = extractFileFromStorage(storageFrom, storageTo, connection);
            transactionUpdate(connection, fileList, storageTo);
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    private void transactionUpdate(Connection connection, List<File> fileList, Storage storageTo) throws SQLException {
        try {
            connection.setAutoCommit(false);
            for (File file : fileList) {
                checkStorageFormatSupported(storageTo, file, connection);
                checkStorageSize(storageTo, file.getSize(), connection);
                update(file);
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Transaction rollback");
            connection.rollback();
            throw e;
        }
    }


    public File transferFile(Storage storageFrom, Storage storageTo, long id) {
        try (Connection connection = getConnection()) {
            File file = findById(id);
            File file2 = new File(file.getId(), file.getName(), file.getFormat(), file.getSize(), new Storage(storageTo.getId()));
            update(file2);
            return file2;
        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    public File save(File file) {

        try (Connection connection = getConnection(); PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO FILE_S VALUES(?, ?, ?, ?, ?)")) {

            preparedStatement.setLong(1, file.getId());
            preparedStatement.setString(2, file.getName());
            preparedStatement.setString(3, file.getFormat());
            preparedStatement.setLong(4, file.getSize());
            if (file.getStorage() != null) {
                checkStorageSize(file.getStorage(), file.getSize(), connection);
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
        try (Connection connection = getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FILE_S WHERE ID = ?");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() && resultSet.getObject(5) != null) {
                return new File(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getLong(4), new Storage(resultSet.getLong(5)));
            } else {
                return new File(resultSet.getLong(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getLong(4));
            }

        } catch (SQLException e) {
            System.err.println("Something went wrong");
            e.printStackTrace();
        }
        return null;
    }

    private void checkStorageSize(Storage storage, long sizeFile, Connection connection) throws SQLException {

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT SIZE_FILE FROM FILE_S WHERE STORAGE = ?");
             PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT STORAGE_MAX_SIZE FROM STORAGE WHERE ID = ?")) {

            preparedStatement.setLong(1, storage.getId());
            preparedStatement1.setLong(1, storage.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSet resultSet1 = preparedStatement1.executeQuery();

            long maxSizeStorage = 0;
            long sumSizeFiles = 0;

            if (resultSet1.next())
                maxSizeStorage = resultSet1.getLong(1);


            while (resultSet.next()) {
                sumSizeFiles = sumSizeFiles + resultSet.getLong(1);
            }

            if ((maxSizeStorage - sumSizeFiles) < sizeFile) {
                System.out.println(maxSizeStorage - sumSizeFiles);
                throw new SQLException("Size file is very big. Save this file is not possible");
            }
        }
    }
}


