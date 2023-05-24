/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.connect.ConnectDB;

/**
 *
 * @author LG
 */
public abstract class DAOAbstract<T, ID> implements DAO<T, ID> {
    protected Connection conn;
    protected Statement stat = null;
    protected ResultSet rs = null;

    public DAOAbstract(ConnectDB connDB) {
        conn = connDB.getConn();
        try {
            stat = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
