package jdbc.lesson4.hw1.services;

import jdbc.lesson4.hw1.model.Storage;
import jdbc.lesson4.hw1.repository.StorageRepository;

public class StorageService {
    StorageRepository storageRepository = new StorageRepository();


    public Storage save (Storage storage) {
        return storageRepository.save(storage);
    }

    public Storage delete (long id) {
        return storageRepository.delete(id);
    }

    public Storage update (Storage storage) {
        return storageRepository.update(storage);
    }

    public Storage findById (long id) {
        return storageRepository.findById(id);
    }
}
