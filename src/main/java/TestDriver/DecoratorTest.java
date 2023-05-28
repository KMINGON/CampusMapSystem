/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDriver;

import model.building.BuildingDAO;
import model.building.FindByNameBuildingDAO;
import model.userData.UserDAO;

/**
 *
 * @author LG
 */
public class DecoratorTest {
    public static void main(String[] args) {
        TestBuildingDecorator test = new TestBuildingDecorator(new FindByNameBuildingDAO(new BuildingDAO()));
        test.testMethod(1);
    }
}
