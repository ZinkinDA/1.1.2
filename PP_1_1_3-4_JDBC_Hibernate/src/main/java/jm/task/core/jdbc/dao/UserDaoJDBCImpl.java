package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connect = new Util().getDbConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String command = "CREATE TABLE IF NOT EXISTS test.user (id INT NOT NULL AUTO_INCREMENT,name VARCHAR(45) NOT NULL,lastName VARCHAR(45) NOT NULL,age INT NOT NULL, PRIMARY KEY(id))";
        try (Statement statement = connect.prepareStatement((command))){
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        String command = "DROP TABLE IF EXISTS test.user";
        try (Statement statement = connect.prepareStatement((command))) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String command = "INSERT INTO test.user (name,lastName,age) VALUES(?,?,?)";
        try (PreparedStatement statement = connect.prepareStatement(command)){
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setInt(3,age);
            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String command = "DELETE FROM test.user WHERE id = ?;";
        try (PreparedStatement statement = connect.prepareStatement(command)){
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String command = "SELECT * FROM test.user";
        try (ResultSet set = connect.createStatement().executeQuery(command)){

            while (set.next()){
                User us = new User(set.getString("name"),
                        set.getString("lastName"),set.getByte("age"));
                us.setId(set.getLong("id"));
                userList.add(us);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        String command = "TRUNCATE TABLE test.user";
        try (Statement statement = connect.prepareStatement(command)){

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
