/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LG
 */
public class ConnectMariaDB implements ConnectDB {

    private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://113.198.235.241:9090/campusmapdb?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "gon";
    private static final String PW = "20193172";
    private static Connection conn;

    public ConnectMariaDB() {    //DB 연결
        //System.out.println("MariaDB 입니다");
        if (conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PW);
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
