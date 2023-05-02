/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

import model.ConnectDb;

/**
 *
 * @author LG
 */
public class SignUpSystem {

    private final String id;
    private final String pw;
    private final String name;

    public SignUpSystem(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public void saveMemberInfo() {
        ConnectDb cd = new ConnectDb();
        cd.signUp(id, pw, name);
    }

}
