/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDriver;

import board.BoardData;
import login.LoginData;

/**
 *
 * @author LG
 */
public class SubjectTest {
    public static void main(String[] args) {
        BoardData boardData = new BoardData();
        LoginData loginData = new LoginData();
        
        new ObserverTest(loginData, boardData);
        new ObserverTest2(loginData, boardData);
        
        boardData.setStatus(null);
        loginData.setStatus(null);
    }
}
