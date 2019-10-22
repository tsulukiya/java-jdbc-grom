package hibernate.lesson4.services;


import hibernate.lesson4.model.Order;
import hibernate.lesson4.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository = new OrderRepository();

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order update(Order order) {
        return orderRepository.update(order);
    }

    public Order delete(long id) {
        return orderRepository.delete(id);
    }

    public Order findById(long id) {
        return orderRepository.findById(id);
    }
}
