/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package board;

import model.boardData.BoardDAO;
import model.boardData.Board;
import model.*;

/**
 *
 * @author LG
 */
public class BoardSystem {
    Board board;
    BoardDAO boardDao;

    public BoardSystem(BoardDAO boardDao) {
        this.boardDao = boardDao;
    }
    
    
    
}
