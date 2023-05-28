/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestDriver;

import board.BoardData;
import login.LoginData;
import observer.Observer;

/**
 *
 * @author LG
 */
public class ObserverTest implements Observer{

    public ObserverTest(LoginData loginData, BoardData boardData) {
        loginData.registerObserver(this);
        boardData.registerObserver(this);
    }
    
    @Override
    public void update() {
        System.out.println("옵저버1의 update 메서드 호출됨");
    }
}
