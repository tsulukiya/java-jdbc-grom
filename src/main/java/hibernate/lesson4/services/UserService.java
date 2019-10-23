package hibernate.lesson4.services;

import hibernate.lesson4.model.User;
import hibernate.lesson4.repository.UserRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    public User registerUser(User user) {
        return userRepository.registerUser(user);
    }

    public void login(String userName, String password) {
       userRepository.login(userName, password);
    }

    public void logout() {
        userRepository.logout();
    }
}

