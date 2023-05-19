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
public class boardDAOImpl implements boardDAO {

    private Connection conn;
    Statement stat = null;
    ResultSet rs = null;

    public boardDAOImpl() {
        ConnectOrcleDb connDB = new ConnectOrcleDb();
        conn = connDB.getConn();
        try {
            stat = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(Post post) {
        try {
            String format = "INSERT INTO %s VALUES(%s, '%s', '%s', '%s', '%s', '%s', %s, %s)";
            String query = String.format(format,
                    "BOARD",
                    post.getBdNo(), post.getUserId(),
                    post.getUserName(), post.getBdTitle(),
                    post.getBdContent(), post.getBdDate(),
                    post.getBdViewCnt(), post.getBdBuildNum());
            stat.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Post> findAll() {
        ArrayList<Post> posts = new ArrayList();
        try {
            String format = "SELECT * FROM %s";
            String query = String.format(format, "BOARD");
            rs = stat.executeQuery(query);
            while (rs.next()) {
                posts.add(new Post(
                        rs.getString("userId"),
                        rs.getString("userName"),
                        rs.getString("bdTitle"),
                        rs.getString("bdContent"),
                        rs.getString("bdDate"),
                        rs.getInt("bdViewCnt"),
                        rs.getInt("bdBuildNum"),
                        rs.getInt("bdNo")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post findById(int no) {
        Post post = null;
        try {
            String format = "SELECT * FROM %s WHERE bdNo = %s";
            String query = String.format(format, "BOARD", no);
            rs = stat.executeQuery(query);
            while (rs.next()) {
                post = new Post(
                        rs.getString("userId"),
                        rs.getString("userName"),
                        rs.getString("bdTitle"),
                        rs.getString("bdContent"),
                        rs.getString("bdDate"),
                        rs.getInt("bdViewCnt"),
                        rs.getInt("bdBuildNum"),
                        rs.getInt("bdNo")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return post;
    }

    @Override
    public void update(int no, Post post) {
        Post p = findById(no);
        if (p != null) {
            try {
                String format = "UPDATE %s SET  userId = '%s', userName = '%s', bdTitle='%s', bdContent='%s', bdDate='%s', bdViewCnt=%s, bdBuildNum=%s WHERE bdNo = %s";
                String query = String.format(
                        format, "BOARD",
                        post.getUserId(), post.getUserName(),
                        post.getBdTitle(), post.getBdContent(),
                        post.getBdDate(), post.getBdViewCnt(),
                        post.getBdBuildNum(), post.getBdNo()
                );
                stat.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Post post) {
        deleteById(post.getBdNo());
    }

    @Override
    public void deleteById(int no) {
        try {
            String format = "DELETE FROM %s WHERE bdNo = %s";
            String query = String.format(format, "BOARD", no);
            stat.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
