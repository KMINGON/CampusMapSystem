/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import model.userData.User;
import model.*;

/**
 *
 * @author LG
 */
public class SignInSystem {

    DAO userDao;
    LoginStatus loginStatus;

    public SignInSystem(DAO userDao, LoginStatus loginStatus) {
        this.userDao = userDao;
        this.loginStatus = loginStatus;
    }

    public boolean signIn(User user) {
        User u = (User)userDao.findById(user.getId());
        if (u != null && u.getPw().equals(user.getPw())) {
            return true;
        }
        return false;
    }

}
