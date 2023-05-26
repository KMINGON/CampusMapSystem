/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.connect;

import java.sql.Connection;

/**
 *
 * @author LG
 */
public class ConnectionPool {

    private static ConnectionPool instance;
    private Connection connection;

    private ConnectionPool(ConnectDB connectDB) {
        this.connection = connectDB.getConn();
    }

    public static ConnectionPool getInstance(ConnectDB connectDB) {
        if (instance == null) {
            instance = new ConnectionPool(connectDB);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
