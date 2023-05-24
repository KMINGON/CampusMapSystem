/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.campusmapsystem;

import java.util.List;
import login.*;
import model.*;

/**
 *
 * @author LG
 */
public class CampusMapSystem {

    public static void main(String[] args) {
        DAO boardDAO = new BoardDAO(new ConnectOrcleDb());
        List<Board> list = boardDAO.findAll();
        for(Board board : list){
            System.out.println(board);
        }
    }
}
