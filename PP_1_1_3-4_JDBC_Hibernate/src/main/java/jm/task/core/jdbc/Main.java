package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Util.getDbConnection();
        UserDao ud = new UserDaoJDBCImpl();

        ud.createUsersTable();

        ud.saveUser("Name1", "LastName1", (byte) 20);
        ud.saveUser("Name2", "LastName2", (byte) 25);
        ud.saveUser("Name3", "LastName3", (byte) 31);
        ud.saveUser("Name4", "LastName4", (byte) 38);

        ud.removeUserById(1);
        ud.getAllUsers();
        ud.cleanUsersTable();
        ud.dropUsersTable();
    }
}
