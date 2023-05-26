/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import board.BoardData;
import login.LoginData;

/**
 *
 * @author LG
 */
public class DataPool {
    private static DataPool instance;
    private LoginData loginData;
    private BoardData boardData;

    private DataPool() {
        loginData = new LoginData();
        boardData = new BoardData();
    }

    public static DataPool getInstance() {
        if (instance == null) {
            instance = new DataPool();
        }
        return instance;
    }

    public BoardData getBoardData() {
        return boardData;
    }
    
    public LoginData getLoginData() {
        return loginData;
    }
}
