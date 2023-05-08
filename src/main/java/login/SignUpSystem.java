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
    UserDAO userDao;

    public SignUpSystem(User user) {
        this.user = user;
    }
    
    public boolean cheackInfo(){
        userDao = new UserDAOImpl();
        if (userDao.findById(user.getId()) != null){
            saveMemberInfo();
            return true;
        }
        return false;
    }
    public void saveMemberInfo() {
        userDao.insert(user);
    }

}
