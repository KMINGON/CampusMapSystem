/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.building;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DAOAbstract;
import model.connect.ConnectDB;

/**
 *
 * @author LG
 */
public class BuildingDAO extends DAOAbstract<Building, Integer>{

    public BuildingDAO(ConnectDB connDB) {
        super(connDB);
    }

    @Override
    public void insert(Building building) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Building> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Building findById(Integer buNo) {
        Building building = null;
        try {
            String format = "SELECT * FROM %s WHERE buNo = %s";
            String query = String.format(format, "BUILDING", buNo);
            rs = stat.executeQuery(query);
            while (rs.next()) {
                building = new Building(
                        rs.getInt("buNo"),
                        rs.getString("nuName"),
                        rs.getString("buExplain"),
                        rs.getString("buLocate"),
                        rs.getString("buImage"),
                        rs.getInt("buFavo")
                );
            }
            query = String.format(format, "BUINFO", buNo);
            rs = stat.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 
    }

    @Override
    public void update(Integer buNo, Building building) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Building building) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(Integer buNo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
