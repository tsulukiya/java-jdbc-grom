package lesson4.hw1.Demo;

import lesson4.hw1.controller.StorageController;
import lesson4.hw1.model.Storage;

public class Demo {
    public static void main(String[] args) {
        Storage storage = new Storage(1003, "jpg,png", "Ukraine", 12332222);
        StorageController storageController = new StorageController();
        storageController.save(storage);
    }

}
