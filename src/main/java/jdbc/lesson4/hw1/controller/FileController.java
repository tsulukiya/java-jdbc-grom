package jdbc.lesson4.hw1.controller;

import jdbc.lesson4.hw1.model.File;
import jdbc.lesson4.hw1.model.Storage;
import jdbc.lesson4.hw1.services.FileService;

import java.util.List;

public class FileController {
    FileService fileService = new FileService();

    public File put(Storage storage, File file) {
        return fileService.put(storage, file);
    }

    public List<File> putAll (Storage storage, List<File>files) {
        return fileService.putAll(storage, files);
    }

    public File delete (Storage storage, File file) {
        return fileService.delete(storage, file);
    }

    public List<File> transferAll(Storage storageFrom, Storage storageTo) {
        return fileService.transferAll(storageFrom, storageTo);
    }

    public File transferFile(Storage storageFrom, Storage storageTo, long id) {
        return  fileService.transferFile(storageFrom, storageTo, id);
    }

    public File save (File file) {
        return fileService.save(file);
    }

    public File delete (long id) {
        return fileService.delete(id);
    }

    public File update (File file) {
        return fileService.update(file);
    }

    public File findById (long id) {
        return fileService.findById(id);
    }
}
