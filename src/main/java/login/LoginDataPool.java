/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author LG
 */
public class LoginDataPool {
    private static LoginDataPool instance;
    private LoginData loginData;

    private LoginDataPool() {
        loginData = new LoginData();
    }

    public static LoginDataPool getInstance() {
        if (instance == null) {
            instance = new LoginDataPool();
        }
        return instance;
    }

    public LoginData getLoginData() {
        return loginData;
    }
}
