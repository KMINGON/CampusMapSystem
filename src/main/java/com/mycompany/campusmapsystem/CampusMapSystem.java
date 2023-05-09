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
        new SignUpSystem(new User("아디", "비번", "이름")).saveMemberInfo();
        System.out.println(new SignInSystem(new User("아디", "비번")).cheackInfo());
    }
}
