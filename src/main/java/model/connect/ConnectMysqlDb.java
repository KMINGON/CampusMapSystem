/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.connect;

import model.connect.ConnectDB;
import java.sql.*;

/**
 *
 * @author LG
 */
public class ConnectMysqlDb implements ConnectDB{

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String jdbcDriver = "jdbc:mysql://49.50.174.5:3306/TestDB?serverTimezone=UTC";
    String dbUser = "gon"; //mysql id
    String dbPass = "20193172"; //mysql password
    private static Connection conn;

    public ConnectMysqlDb() {
        System.out.println("MysqlDB 입니다");
        if (conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Connection getConn() {
        return conn;
    }
}
