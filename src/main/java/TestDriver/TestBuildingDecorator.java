/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDriver;

import model.DAO;
import model.DAODecorator;
import model.building.Building;
import model.building.FindByNameBuildingDAO;

/**
 *
 * @author LG
 */
public class TestBuildingDecorator extends DAODecorator<Building, Integer> {
    
    public TestBuildingDecorator(DAO dao) {
        super(dao);
    }
    public void testMethod(int n){
        Building budilding;
        System.out.println();
        
        FindByNameBuildingDAO dDao = (FindByNameBuildingDAO)dao;
        budilding = dDao.findByName(dao.findById(n).getBuName());
        System.out.println(budilding.getBuExplain());
        
        System.out.println("id로 건물 데이터를 찾는 기존 기능과 이름으로 건물을 찾는 데코레이터의 기능을 합치고 확장할 수 있는 메서드 입니다.");
        
    }
}
