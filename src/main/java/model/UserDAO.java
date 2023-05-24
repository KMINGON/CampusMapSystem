/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.*;

/**
 *
 * @author LG
 */
public class UserDAO implements DAO<User, String> {

    private Connection conn;
    Statement stat = null;
    ResultSet rs = null;

    public UserDAO(ConnectDB connDB) {
        conn = connDB.getConn();
        try {
            stat = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(User user) {
        try {
            String format = "INSERT INTO %s VALUES('%s', '%s', '%s')";
            String query = String.format(format, "MEMBER", user.getId(), user.getPw(), user.getName());
            stat.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> users = new ArrayList();
        try {
            String format = "SELECT * FROM %s";
            String query = String.format(format, "MEMBER");
            rs = stat.executeQuery(query);
            while (rs.next()) {
                users.add(new User(
                        rs.getString("id"),
                        rs.getString("pw"),
                        rs.getString("name")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(String id) {
        User user = null;
        try {
            String format = "SELECT * FROM %s WHERE id = '%s'";
            String query = String.format(format, "MEMBER", id);
            rs = stat.executeQuery(query);
            while (rs.next()) {
                user = new User(
                        rs.getString("id"),
                        rs.getString("pw"),
                        rs.getString("name")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(String id, User user) {
        User u = findById(id);
        if (u != null) {
            try {
                String format = "UPDATE %s SET pw = '%s', name ='%s' WHERE id = '%s'";
                String query = String.format(format, "MEMBER", user.getPw(), user.getName(), user.getId());
                stat.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(User user) {
        deleteById(user.getId());
    }

    @Override
    public void deleteById(String id) {
        try {
            String format = "DELETE FROM %s WHERE id = '%s'";
            String query = String.format(format, "MEMBER", id);
            stat.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
