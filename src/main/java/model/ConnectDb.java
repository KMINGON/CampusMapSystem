/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;

/**
 *
 * @author LG
 */
public class ConnectDb {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@sedb.deu.ac.kr:1521/orcl";
    private static final String USER = "a20193172";
    private static final String PW = "20193172";
    private Connection conn;

    public ConnectDb() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PW);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void signUp(String id, String pw, String name) {
        try {
            String sql = "INSERT INTO member VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            pstmt.setString(3, name);
            int result = pstmt.executeUpdate();
            
            if (result > 0) {
                System.out.println("회원 가입이 완료되었습니다.");
            } else {
                System.out.println("회원 가입에 실패하였습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
