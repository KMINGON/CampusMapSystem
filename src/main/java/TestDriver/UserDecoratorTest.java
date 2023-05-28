/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDriver;

import model.DAO;
import model.DAODecorator;
import model.userData.User;

/**
 *
 * @author LG
 */
public class UserDecoratorTest extends DAODecorator<User, String> {

    public UserDecoratorTest(DAO<User, String> dao) {
        super(dao);
    }

    public void testMethod() {
        System.out.println(dao.findById("gon"));
        System.out.println("테스트 데코레이터의 기능과 UserDAO의 findByID 메소드를 합친 메서드 호출");
    }
}
