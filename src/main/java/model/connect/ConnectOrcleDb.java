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
public class ConnectOrcleDb implements ConnectDB {    //DB 관리

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@sedb.deu.ac.kr:1521/orcl";
    private static final String USER = "a20193172";
    private static final String PW = "20193172";
    private static Connection conn;

    public ConnectOrcleDb() {    //DB 연결
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
