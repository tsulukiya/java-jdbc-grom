package hibernate.lesson4.repository;


import hibernate.lesson4.model.User;

public class UserRepository {
    ShareRepository shareRepository = new ShareRepository();
    private static String sqlUserFindById = "from User where id = :code";

    public User save(User user) {
        return (User) shareRepository.save(user);
    }

    public User update(User user) {
        return (User) shareRepository.update(user);
    }

    public User delete(long id) {
        return (User) shareRepository.delete(id, sqlUserFindById);
    }

    public User findById(long id) {
        return (User) shareRepository.findById(id, sqlUserFindById);
    }
}
