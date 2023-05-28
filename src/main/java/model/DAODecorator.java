/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author LG
 * @param <T>
 * @param <ID>
 */
public abstract class DAODecorator<T, ID> extends DAOAbstract<T, ID> {

    protected DAO<T, ID> dao;

    public DAODecorator(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void insert(T entity) {
        dao.insert(entity);
    }

    @Override
    public List<T> findAll() {
        return dao.findAll();
    }

    @Override
    public T findById(ID id) {
        return dao.findById(id);
    }

    @Override
    public void update(ID id, T entity) {
        dao.update(id, entity);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        dao.deleteById(id);
    }

}
