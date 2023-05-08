/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.campusmapsystem;

import login.*;
import model.*;

/**
 *
 * @author LG
 */
public class CampusMapSystem {

    public static void main(String[] args) {
        UserDAO userDao = new UserDAOImpl();
        System.out.println(userDao.findById("asdk"));
    }
}
