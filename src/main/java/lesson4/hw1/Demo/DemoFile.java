package lesson4.hw1.Demo;

import lesson4.hw1.controller.FileController;
import lesson4.hw1.model.File;
import lesson4.hw1.model.Storage;

import java.util.ArrayList;
import java.util.List;

public class DemoFile {
    public static void main(String[] args) {
        Storage storage = new Storage(1005);
        File file1 = new File(5011, "Eyes", "jpeg", 1000);
        File file2 = new File(5012, "Eyes", "jpeg", 1000);
        File file3 = new File(5013, "Eyes", "jpeg", 1000);
        File file4 = new File(5014, "Eyes", "jpeg", 1000);
        File file5 = new File(5015, "Eyes", "jpeg", 1000);
        File file6 = new File(5016, "Eyes", "jpeg", 1000);
        File file7 = new File(5017, "Eyes", "jpeg", 13000);
//        List<File> files = new ArrayList<>();
//        files.add(file1);
//        files.add(file2);
//        files.add(file3);
//        files.add(file4);
//        files.add(file5);
//        files.add(file6);
//        files.add(file7);

        FileController fileController = new FileController();
//
//        fileController.save(file2);
//        fileController.save(file3);
//        fileController.save(file4);
//        fileController.save(file5);
//        fileController.save(file6);
//        fileController.save(file7);

//        fileController.delete(5012);
//        fileController.delete(5013);
//        fileController.delete(5014);
//        fileController.delete(5015);
//        fileController.delete(5016);
//        fileController.delete(5017);
        //fileController.update(file);
        //System.out.println(fileController.findById(5005));
        //System.out.println(fileController.findById(5006));
        //fileController.put(storage, file7);
        //fileController.putAll(storage, files);
    }
}
