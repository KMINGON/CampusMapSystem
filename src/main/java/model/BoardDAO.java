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
public interface BoardDAO {
    public void insert(Board board);
    public List<Board> findAll();
    public Board findById(int id);
    public void update(int id, Board board);
    public void delete(Board board);
    public void deleteById(int id);
}
