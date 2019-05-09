package lesson4.hw1.Demo;

import lesson4.hw1.controller.FileController;
import lesson4.hw1.model.File;
import lesson4.hw1.model.Storage;

public class DemoFile {
    public static void main(String[] args) {
        Storage storage = new Storage(1005);
        File file = new File(5005, "Eyes", "jpeg", 3000, storage);
        File file1 = new File(5006, "Eyes", "jpeg", 3000);
        FileController fileController = new FileController();

        //fileController.save(file1);
        //fileController.delete(5001);
        //fileController.update(file);
    }
}
