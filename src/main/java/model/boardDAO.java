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
public interface boardDAO {
    public void insert(Post post);
    public List<Post> findAll();
    public User findById(int no);
    public void update(Post post);
    public void delete(Post post);
    public void deleteById(int no);
}
