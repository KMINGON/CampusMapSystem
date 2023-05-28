/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDriver;

import model.userData.UserDAO;

/**
 *
 * @author LG
 */
public class DecoratorTest {
    public static void main(String[] args) {
        UserDecoratorTest userDecoratorTest = new UserDecoratorTest(new UserDAO());
        userDecoratorTest.testMethod();
    }
}
