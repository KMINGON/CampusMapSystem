/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author LG
 * @param <T>
 * @param <ID>
 */
public interface DAO<T, ID>{
    public abstract void insert(T entity);
    public abstract List<T> findAll();
    public abstract T findById(ID id);
    public abstract void update(ID id, T entity);
    public abstract void delete(T entity);
    public abstract void deleteById(ID id);
}
