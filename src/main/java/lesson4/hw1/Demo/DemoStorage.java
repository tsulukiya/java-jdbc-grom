package lesson4.hw1.Demo;

import lesson4.hw1.controller.StorageController;
import lesson4.hw1.model.Storage;

public class DemoStorage {
    public static void main(String[] args) {
        Storage storage = new Storage(1004, "jpg,png", "Ukraine", 2202);
        StorageController storageController = new StorageController();
        storageController.save(storage);
    }

}
