/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDriver;

import model.connect.ConnectDB;
import model.connect.ConnectMariaDB;
import model.connect.ConnectMysqlDb;
import model.connect.ConnectOrcleDb;

/**
 *
 * @author LG
 */
public class StrategyTest {
    public static void main(String[] args) {
        connectTest(new ConnectOrcleDb());
        connectTest(new ConnectMysqlDb());
        connectTest(new ConnectMariaDB());
    }
    public static void connectTest(ConnectDB connectDb){
        connectDb.getConn();
    }
}
