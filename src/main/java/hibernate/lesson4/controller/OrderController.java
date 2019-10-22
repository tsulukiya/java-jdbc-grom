package hibernate.lesson4.controller;

import hibernate.lesson4.model.Order;
import hibernate.lesson4.services.OrderService;


public class OrderController {
    OrderService orderService = new OrderService();

    public Order save(Order order) {
        return orderService.save(order);
    }

    public Order update(Order order) {
        return orderService.update(order);
    }

    public Order delete(long id) {
        return orderService.delete(id);
    }

    public Order findById(long id) {
        return orderService.findById(id);
    }
}
