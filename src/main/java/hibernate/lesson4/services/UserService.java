package hibernate.lesson4.services;

import hibernate.lesson4.model.User;
import hibernate.lesson4.repository.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

    public User delete(long id) {
        return userRepository.delete(id);
    }

    public User findById(long id) {
        return userRepository.findById(id);
    }
}

