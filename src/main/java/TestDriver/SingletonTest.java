/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDriver;

import model.DataPool;
import model.connect.ConnectMariaDB;
import model.connect.ConnectionPool;

/**
 *
 * @author LG
 */
public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("첫 번째 인스턴스 받아옴");
        System.out.println(DataPool.getInstance().getLoginData());
        System.out.println(DataPool.getInstance().getBoardData());
        System.out.println(ConnectionPool.getInstance(new ConnectMariaDB()).getConnection());
        
        System.out.println("두 번째 인스턴스 받아옴");
        System.out.println(DataPool.getInstance().getLoginData());
        System.out.println(DataPool.getInstance().getBoardData());
        System.out.println(ConnectionPool.getInstance(new ConnectMariaDB()).getConnection());
    }
}
