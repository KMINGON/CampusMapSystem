/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.userData;

/**
 *
 * @author LG
 */
public class User {

    private String id;
    private String pw;
    private String name;

    public User(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
        this.name = null;
    }

    @Override
    public String toString() {
        return "id: " + id + " / "
                + "pw: " + pw + " / "
                + "name: " + name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
