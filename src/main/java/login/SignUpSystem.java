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
public class SignUpSystem {

    User user;
    DAO userDao;

    public SignUpSystem(DAO userDao) {
        this.userDao = userDao;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    private boolean cheackInfo() {
        if (userDao.findById(user.getId()) == null) {
            return true;
        }
        return false;
    }

    public void saveMemberInfo() {
        if (cheackInfo()) {
            userDao.insert(user);
        }
    }
}
