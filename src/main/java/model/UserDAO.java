/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.*;

/**
 *
 * @author LG
 */
public interface UserDAO {
    public void insert(User user);
    public List<User> findAll();
    public User findById(String id);
    public void update(String id, User user);
    public void delete(User user);
    public void deleteById(String id);
}
