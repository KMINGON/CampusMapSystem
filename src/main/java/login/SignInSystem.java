/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import model.*;

/**
 *
 * @author LG
 */
public class SignInSystem {
    User user;
    UserDAO userDao;

    public SignInSystem(User user) {
        this.user = user;
    }
    
    public boolean cheackInfo(){
        userDao = new UserDAOImpl();
        User u = userDao.findById(user.getId());
        if (u != null && u.getPw().equals(user.getPw())){
            return true;
        }
        return false;
    }
}
