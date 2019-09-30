package jdbc.lesson4.hw1.services;

import jdbc.lesson4.hw1.model.File;
import jdbc.lesson4.hw1.model.Storage;
import jdbc.lesson4.hw1.repository.FileRepository;

import java.sql.SQLException;
import java.util.List;

public class FileService {
    FileRepository fileRepository = new FileRepository();

    public File put(Storage storage, File file) {
        try {
            checkStorageInFile(file);
        } catch (SQLException e) {
            System.err.println("Put storage in this file - impossible, but:" + e.getMessage());
        }
        return fileRepository.put(storage, file);
    }

    public List<File> putAll(Storage storage, List<File> files) {
        return fileRepository.putAll(storage, files);
    }

    public File delete(Storage storage, File file) {
        return fileRepository.delete(storage, file);
    }

    public List<File> transferAll(Storage storageFrom, Storage storageTo) throws SQLException {
        return fileRepository.transferAll(storageFrom, storageTo);
    }

    public File transferFile(Storage storageFrom, Storage storageTo, long id) {
        return fileRepository.transferFile(storageFrom, storageTo, id);
    }

    public File save(File file) {
        return fileRepository.save(file);
    }

    public File delete(long id) {
        return fileRepository.delete(id);
    }

    public File update(File file) {
        return fileRepository.update(file);
    }

    public File findById(long id) {
        return fileRepository.findById(id);
    }

    private void checkStorageInFile(File file) throws SQLException {
        if (file.getStorage() != null)
            throw new SQLException("This file with ID = " + file.getId() + " is have storage.");
    }
}
