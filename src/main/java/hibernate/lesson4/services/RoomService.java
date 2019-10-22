package hibernate.lesson4.services;


import hibernate.lesson4.model.Filter;
import hibernate.lesson4.model.Room;
import hibernate.lesson4.repository.RoomRepository;

import java.util.Date;
import java.util.List;

public class RoomService {
    private RoomRepository roomRepository = new RoomRepository();

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public Room update(Room room) {
        return roomRepository.update(room);
    }

    public Room delete(long id) {
        return roomRepository.delete(id);
    }

    public Room findById(long id) {
        return roomRepository.findById(id);
    }

    public List<Room> findRooms(Filter filter) {
        return roomRepository.findRooms(filter);
    }

}
