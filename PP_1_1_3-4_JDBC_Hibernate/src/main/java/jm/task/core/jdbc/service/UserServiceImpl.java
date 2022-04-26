package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDJI = new UserDaoJDBCImpl();
    public void createUsersTable() {
        userDJI.createUsersTable();
    }

    public void dropUsersTable() {
        userDJI.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDJI.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        userDJI.removeUserById(id);
    }

    public List<User> getAllUsers() {

        return userDJI.getAllUsers();
    }

    public void cleanUsersTable() {
        userDJI.cleanUsersTable();

    }
}
