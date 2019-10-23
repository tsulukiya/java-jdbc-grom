package hibernate.lesson4.controller;



import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Room;
import hibernate.lesson4.services.RoomService;

import java.util.Date;
import java.util.List;


public class RoomController {
    private RoomService roomService = new RoomService();

    public Room save(Room room) {
        return roomService.save(room);
    }

    public Room update(Room room) {
        return roomService.update(room);
    }

    public Room delete(long id) {
        return roomService.delete(id);
    }

    public Room findById(long id) {
        return roomService.findById(id);
    }

    public List<Room> findRooms(Filter filter) {
        return roomService.findRooms(filter);
    }

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) {
        roomService.bookRoom(roomId, userId, dateFrom,dateTo);
    }

    public void cancelReservation(long roomId, long userId) {
        roomService.cancelReservation(roomId, userId);
    }

}
