package hibernate.lesson4.Demo;


import hibernate.lesson4.controller.RoomController;
import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Hotel;
import hibernate.lesson4.model.Room;

import javax.security.auth.login.LoginException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DemoRoom {

    public static void main(String[] args) {

        Room room1 = new Room(341,1, 1900.00, 0, 0, new Date(), new Hotel(133));
        Room room2 = new Room(2, 200.00, 0, 1, new Date(), new Hotel(135));
        Room room3 = new Room(5, 180.00, 0, 1, new Date());
        Room room4 = new Room(6, 190.00, 1, 1, new Date());
        Room room5 = new Room(8, 197.00, 1, 1, new Date());

        Filter filter = new Filter(2,200.00,0,1,new Date(),
                "Ukraine", "Kiev");

        Filter filter1 = new Filter(4,200.00,1,0,new Date(),
                "Ukraine", "Kiev");

        RoomController roomController = new RoomController();
        //roomController.save(room2);
        //roomController.update(room1);
        //roomController.delete(309);

        System.out.println(roomController.findRooms(filter1));
    }
}
