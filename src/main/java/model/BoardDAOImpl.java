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
public class BoardDAOImpl implements BoardDAO {

    private Connection conn;
    Statement stat = null;
    ResultSet rs = null;

    public BoardDAOImpl() {
        ConnectOrcleDb connDB = new ConnectOrcleDb();
        conn = connDB.getConn();
        try {
            stat = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insert(Board board) {
        try {
            String format = "INSERT INTO %s(bdNo, userId, userName, bdTitle, bdContent, bdViewCnt, bdBuildNum) VALUES(%s, '%s', '%s', '%s', '%s', %s, %s)";
            String query = String.format(format,
                    "BOARD",
                    board.getBdNo(), board.getUserId(),
                    board.getUserName(), board.getBdTitle(),
                    board.getBdContent(),board.getBdViewCnt(), board.getBdBuildNum());
            stat.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Board> findAll() {
        ArrayList<Board> boards = new ArrayList();
        try {
            String format = "SELECT * FROM %s";
            String query = String.format(format, "BOARD");
            rs = stat.executeQuery(query);
            while (rs.next()) {
                boards.add(new Board(
                        rs.getString("userId"),
                        rs.getString("userName"),
                        rs.getString("bdTitle"),
                        rs.getString("bdContent"),
                        rs.getTimestamp("bdDate"),
                        rs.getInt("bdViewCnt"),
                        rs.getInt("bdBuildNum"),
                        rs.getInt("bdNo")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return boards;
    }

    @Override
    public Board findById(int id) {
        Board board = null;
        try {
            String format = "SELECT * FROM %s WHERE bdNo = %s";
            String query = String.format(format, "BOARD", id);
            rs = stat.executeQuery(query);
            while (rs.next()) {
                board = new Board(
                        rs.getString("userId"),
                        rs.getString("userName"),
                        rs.getString("bdTitle"),
                        rs.getString("bdContent"),
                        rs.getTimestamp("bdDate"),
                        rs.getInt("bdViewCnt"),
                        rs.getInt("bdBuildNum"),
                        rs.getInt("bdNo")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return board;
    }

    @Override
    public void update(int id, Board board) {
        Board p = findById(id);
        if (p != null) {
            try {
                String format = "UPDATE %s SET  userId = '%s', userName = '%s', bdTitle='%s', bdContent='%s', bdDate='%s', bdViewCnt=%s, bdBuildNum=%s WHERE bdNo = %s";
                String query = String.format(
                        format, "BOARD",
                        board.getUserId(), board.getUserName(),
                        board.getBdTitle(), board.getBdContent(),
                        board.getBdDate(), board.getBdViewCnt(),
                        board.getBdBuildNum(), board.getBdNo()
                );
                stat.executeUpdate(query);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(Board board) {
        deleteById(board.getBdNo());
    }

    @Override
    public void deleteById(int id) {
        try {
            String format = "DELETE FROM %s WHERE bdNo = %s";
            String query = String.format(format, "BOARD", id);
            stat.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
