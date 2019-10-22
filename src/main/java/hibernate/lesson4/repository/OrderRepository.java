package hibernate.lesson4.repository;


import hibernate.lesson4.model.Order;

public class OrderRepository {
    ShareRepository shareRepository = new ShareRepository();
    UserRepository userRepository = new UserRepository();
    RoomRepository roomRepository = new RoomRepository();
    private static String sqlUserFindById = "from Order where id = :code";

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
        return (Order) shareRepository.delete(id, sqlUserFindById);
    }

    public Order findById(long id) {
        return (Order) shareRepository.findById(id, sqlUserFindById);
    }

}
