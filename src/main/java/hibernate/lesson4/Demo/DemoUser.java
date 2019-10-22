package hibernate.lesson4.Demo;


import hibernate.lesson4.controller.UserController;
import hibernate.lesson4.enums.UserType;
import hibernate.lesson4.model.User;

public class DemoUser {

    public static void main(String[] args) {

        User user = new User("Ivan", "1111111111", "USA", UserType.USER);

        UserController userController = new UserController();

//        userController.save(user);
//        userController.update(user);
//        System.out.println(userController.findById(14));
        userController.delete(149);



    }
}
