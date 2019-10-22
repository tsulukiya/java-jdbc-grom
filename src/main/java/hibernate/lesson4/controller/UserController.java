package hibernate.lesson4.controller;


import hibernate.lesson4.model.User;
import hibernate.lesson4.services.UserService;

public class UserController {
    private UserService userService = new UserService();

    public User save(User user) {
        return userService.save(user);
    }

    public User update(User user) {
        return userService.update(user);
    }

    public User delete(long id) {
        return userService.delete(id);
    }

    public User findById(long id) {
        return userService.findById(id);
    }

}
