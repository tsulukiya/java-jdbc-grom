package jdbc.lesson4.hw1.Demo;

import jdbc.lesson4.hw1.controller.FileController;
import jdbc.lesson4.hw1.model.File;
import jdbc.lesson4.hw1.model.Storage;

import java.util.ArrayList;
import java.util.List;

public class DemoFile {
    public static void main(String[] args) {
        Storage storage = new Storage(1005);
        Storage storage1 = new Storage(1002);
        Storage storage2 = new Storage(1003);
        Storage storage3 = new Storage(1004);
        File file1 = new File(5011, "Eyes", "jpg", 1000);
        File file2 = new File(5012, "Eyes", "jpg", 1000);
        File file3 = new File(5013, "Eyes", "jpg", 1000);
        File file4 = new File(5014, "Eyes", "jpg", 1000);
        File file5 = new File(5015, "Eyes", "jpg", 1000);
        File file6 = new File(5016, "Eyes", "jpg", 1000);
        File file7 = new File(5017, "Eyes", "jpg", 130);
        File file8 = new File(5018, "Eyes", "jpg", 130);
        File file9 = new File(5019, "Eyes", "jpge", 130);
        File file11 = new File(5001, "Eyes", "jpg", 130000);
        List<File> files = new ArrayList<>();
        files.add(file1);
        files.add(file2);
        files.add(file3);
        files.add(file4);
        files.add(file5);
        files.add(file6);
        files.add(file7);
        files.add(file8);

        FileController fileController = new FileController();
//
//        fileController.save(file2);
//        fileController.save(file3);
//        fileController.save(file4);
//        fileController.save(file5);
//        fileController.save(file6);
//        fileController.save(file7);
//        fileController.save(file8);
//        fileController.save(file9);

//        fileController.delete(5012);
//        fileController.delete(5013);
//        fileController.delete(5014);
//        fileController.delete(5015);
//        fileController.delete(5016);
//        fileController.delete(5017);
//        fileController.delete(5001);
//        fileController.delete(5002);
//        fileController.delete(5006);
//        fileController.delete(5005);
//        fileController.delete(5008);
//        fileController.delete(5019);
        //fileController.update(file);
        //System.out.println(fileController.findById(5005));
        //System.out.println(fileController.findById(5006));
        //fileController.put(storage1, file9);
        //fileController.putAll(storage, files);
        //fileController.delete(storage, file6);

        //fileController.transferAll(storage3,storage);
        //fileController.transferFile(storage,storage3, 5012);
    }
}
