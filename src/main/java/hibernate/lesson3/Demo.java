package hibernate.lesson3;

import java.util.Date;

public class Demo {

    public static void main(String[] args) {

        Hotel hotel = new Hotel(13,"Hilton", "USA", "New York","Street");

        Room room = new Room(47,4, 1000.00, 1, 0, new Date(), hotel);
        Room room1 = new Room(2, 1000.00, 1, 0, new Date(), hotel);

        RoomDao roomDao = new RoomDao();
        HotelDao hotelDao = new HotelDao();

        //roomDao.save(room1);

        System.out.println(roomDao.findById(49));
        //System.out.println(hotelDao.findById(13));
        //roomDao.update(room);
    }
}
