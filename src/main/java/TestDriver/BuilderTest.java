/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDriver;

import model.boardData.Board;
import model.boardData.BoardBuilder;

/**
 *
 * @author LG
 */
public class BuilderTest {
    public static void main(String[] args) {
        Board board = new BoardBuilder(
                "UserID",
                "UserName",
                "BoardTitle",
                "BoardContent").
                bdBuildNum(1).
                bdNo(2).
                bdViewCnt(3).
                build();
        System.out.println(board);
    }
}
