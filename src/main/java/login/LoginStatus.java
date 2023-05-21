/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import java.util.*;

/**
 *
 * @author LG
 */
public class LoginStatus implements Subject{
    private List<Observer> observers;
    private int status;

    public LoginStatus() {
        observers = new ArrayList<Observer>();
    }
    
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            observer.update(status);
        }
    }

    public void setStatus(int status) {
        this.status = status;
        notifyObserver();
    }
    
    
    
}
