package lesson4.hw1.Demo;

import lesson4.hw1.controller.StorageController;
import lesson4.hw1.model.Storage;

public class DemoStorage {
    public static void main(String[] args) {
        Storage storage = new Storage(1005, "jpg,png", "Ukraine", 22002);
        Storage storage1 = new Storage(1002, "jpg,png", "Ukraine", 22002);
        Storage storage2 = new Storage(1003, "png", "Ukraine", 22002);
        Storage storage3 = new Storage(1004, "jpg", "Ukraine", 5000);
        StorageController storageController = new StorageController();

        storageController.save(storage3);

        //storageController.delete(1004);

        //storageController.update(storage1);

        //System.out.println(storageController.findById(1002));
    }

}
