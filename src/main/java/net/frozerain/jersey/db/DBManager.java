package net.frozerain.jersey.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private String url;
    private String user;
    private String password;
    private Connection connection;

    public DBManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;

        try {
            Class.forName("org.h2.Driver");
            System.out.println("START CONNECTING...");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("CONNECTED TO DB");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return this.connection;
    }
    public void closeConnection() throws SQLException {
        this.connection.close();
    }
}
