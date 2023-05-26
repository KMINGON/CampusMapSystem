/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import model.userData.User;
import model.*;
import model.userData.UserDAO;

/**
 *
 * @author LG
 */
public class SignUpSystem {
    DAO userDao;

    public SignUpSystem() {
        this.userDao = new UserDAO();
    }
    
    public void registerUser(User user) {
        userDao.insert(user);
    }
    
    
    public boolean cheackInfo(String id) {
        if (userDao.findById(id) == null) {
            return true;
        }
        return false;
    }
}
