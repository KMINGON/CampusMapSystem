/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.boardData;

import java.sql.SQLException;
import model.DAO;
import model.DAODecorator;

/**
 *
 * @author LG
 */
public class IncreaseViewCountBoardDAO extends DAODecorator<Board, Integer> {

    public IncreaseViewCountBoardDAO(DAO dao) {
        super(dao);
    }

    public void IncreaseViewCount(int bdNo) {
        try {
            String format = "UPDATE FROM %s SET bdViewCnt = bdViewCnt + 1 WHERE bdNo = %d";
            String query = String.format(format, "BOARD", bdNo);
            stat.executeUpdate(query);
        } catch (SQLException ex) {
        }
    }
}
