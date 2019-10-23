package hibernate.lesson4.repository;


import hibernate.lesson4.model.Order;
import hibernate.lesson4.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderRepository {
    ShareRepository shareRepository = new ShareRepository();
    UserRepository userRepository = new UserRepository();
    RoomRepository roomRepository = new RoomRepository();
    private static String sqlOrderFindById = "from Order where id = :code";

    public Order save(Order order) {
        order.setUserOrdered(userRepository.findById(order.getUserOrdered().getId()));
        order.setRoom(roomRepository.findById(order.getRoom().getId()));
        return (Order) shareRepository.save(order);
    }

    public Order update(Order order) {
        order.setUserOrdered(userRepository.findById(order.getUserOrdered().getId()));
        order.setRoom(roomRepository.findById(order.getRoom().getId()));
        return (Order) shareRepository.update(order);
    }

    public Order delete(long id) {
        return (Order) shareRepository.delete(id, sqlOrderFindById);
    }

    public Order findById(long id) {
        return (Order) shareRepository.findById(id, sqlOrderFindById);
    }
}
