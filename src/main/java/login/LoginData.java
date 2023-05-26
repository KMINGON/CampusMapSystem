/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import observer.Subject;
import observer.Observer;
import java.util.ArrayList;
import java.util.List;
import model.userData.User;

/**
 *
 * @author LG
 */
public class LoginData implements Subject{
    private List<Observer> observers;
    private User user;

    public LoginData() {
        observers = new ArrayList<Observer>();
        user = null;
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
            observer.update();
        }
    }
    
    public User getUser(){
        return this.user;
    }

    public void setStatus(User user) {
        this.user = user;
        notifyObserver();
    }
}
