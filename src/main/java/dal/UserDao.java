package dal;

import bo.User;

public interface UserDao {

    void insert(User user);

    User selectByUsername(String username);
}
