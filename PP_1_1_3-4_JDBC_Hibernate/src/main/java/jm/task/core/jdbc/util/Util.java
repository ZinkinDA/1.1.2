package jm.task.core.jdbc.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;


public class Util {
    private static final String dbHost = "localhost";
    private static final String dbPort = "3306";
    private static final String dbUser = "root";
    private static final String dbPass = "assasin!23S!";
    private static final String dbName = "testdb";

    private static Connection dbConnection;
    private static Driver dbDriver ;

    public static Connection getDbConnection(){
        String connectString = "jdbc:mysql://localhost:3306/?user=root&password=assasin!23S!";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection(connectString);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }


}
