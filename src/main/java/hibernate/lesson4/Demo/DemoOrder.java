package hibernate.lesson4.Demo;


import hibernate.lesson4.controller.OrderController;
import hibernate.lesson4.model.Order;
import hibernate.lesson4.model.Room;
import hibernate.lesson4.model.User;

import java.util.Date;

public class DemoOrder {
    public static void main(String[] args) {

        Order order = new Order(155, new User(149), new Room(329), new Date(), new Date(), 1500.00);

        OrderController orderController = new OrderController();

        //orderController.save(order);
        //orderController.update(order);
        //orderController.findById(155);
        //orderController.delete(155);
    }
}
