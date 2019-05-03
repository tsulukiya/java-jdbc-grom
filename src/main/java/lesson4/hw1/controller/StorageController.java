package lesson4.hw1.controller;

import lesson4.hw1.model.Storage;
import lesson4.hw1.services.StorageService;

public class StorageController {
    StorageService storageService = new StorageService();

    public Storage save (Storage storage) {
        return storageService.save(storage);
    }

    public Storage delete (long id) {
        return storageService.delete(id);
    }

    public Storage update (Storage storage) {
        return storageService.update(storage);
    }

    public Storage findById (long id) {
        return storageService.findById(id);
    }
}
