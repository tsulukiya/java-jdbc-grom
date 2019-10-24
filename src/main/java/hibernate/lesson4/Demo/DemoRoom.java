package hibernate.lesson4.Demo;


import hibernate.lesson4.controller.RoomController;
import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Hotel;
import hibernate.lesson4.model.Room;
import java.util.Date;


public class DemoRoom {

    public static void main(String[] args) {

        Room room1 = new Room(341,1, 1900.00, 0, 0, new Date(), new Hotel(133));
        Room room2 = new Room(2, 200.00, 0, 1, new Date(), new Hotel(135));
        Room room3 = new Room(5, 180.00, 0, 1, new Date());
        Room room4 = new Room(6, 190.00, 1, 1, new Date());
        Room room5 = new Room(8, 197.00, 1, 1, new Date());

        Filter filter = new Filter(2,200.00,0,1,new Date(),
                "Ukraine", "Kiev");

        Filter filter1 = new Filter(1,1900.00,0,0,new Date(),
                "Ukraine", "Kiev");

        RoomController roomController = new RoomController();
        //roomController.save(room2);
        //roomController.update(room1);
        //roomController.delete(309);
        //roomController.bookRoom(361, 151, new Date(), new Date());
        //roomController.cancelReservation(361, 151);

        System.out.println(roomController.findRooms(filter));
    }
}
