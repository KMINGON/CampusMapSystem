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

    private String id;
    private String pw;
    private String name;

    public SignUpSystem(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }
    public void cheackInfo(){
        UserDAO userDao = new UserDAOImpl();
        if (userDao.findById(id) != null){
            
        }
    }
    public void saveMemberInfo() {
        
    }

}
