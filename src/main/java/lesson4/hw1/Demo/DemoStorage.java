package lesson4.hw1.Demo;

import lesson4.hw1.controller.StorageController;
import lesson4.hw1.model.Storage;

public class DemoStorage {
    public static void main(String[] args) {
        Storage storage = new Storage(1005, "jpg,png", "Ukraine", 22002);
        Storage storage1 = new Storage(1002, "jpg,png", "Ukraine", 22002);
        StorageController storageController = new StorageController();

        //storageController.save(storage);

        //storageController.delete(1004);

        //storageController.update(storage1);

        System.out.println(storageController.findById(1002));
    }

}
