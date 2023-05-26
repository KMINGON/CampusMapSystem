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
public class SignInSystem {

    DAO userDao;
    LoginData loginData;

    public SignInSystem() {
        this.userDao = new UserDAO();
        this.loginData = LoginDataPool.getInstance().getLoginData();
    }

    public User signIn(User user) {
        User u = (User)userDao.findById(user.getId());
        if (u != null && u.getPw().equals(user.getPw())) {
            loginData.setStatus(u);
            return u;
        }
        return null;
    }

}
