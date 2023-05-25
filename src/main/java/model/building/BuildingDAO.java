/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.building;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.DAOAbstract;

/**
 *
 * @author LG
 */
public class BuildingDAO extends DAOAbstract<Building, Integer> {

    @Override
    public void insert(Building building) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Building> findAll() {
        ArrayList<Building> buildings = new ArrayList();
        try {
            String format = "SELECT * FROM %s";
            String query = String.format(format, "BUILDING");
            rs = stat.executeQuery(query);
            while (rs.next()) {
                ArrayList<BuInfo> buInfos = new ArrayList();
                Building building = null;
                building = new Building(
                        rs.getInt("buNo"),
                        rs.getString("buName"),
                        rs.getString("buExplain"),
                        rs.getInt("buLocateX"),
                        rs.getString("buLocateY"),
                        rs.getString("buImage"),
                        rs.getInt("buFavo")
                );

                String biFormat = "SELECT * FROM %s WHERE buNo = %d";
                query = String.format(biFormat, "BUINFO", building.getBuNo());
                Statement biStat = conn.createStatement();
                ResultSet rsTemp = biStat.executeQuery(query);
                while (rsTemp.next()) {
                    BuInfo buInfo = new BuInfo(
                            rsTemp.getInt("buNo"),
                            rsTemp.getString("biFloor"),
                            rsTemp.getString("biName")
                    );
                    buInfos.add(buInfo);
                }
                building.setBuInfos(buInfos);
                buildings.add(building);
            }
        } catch (SQLException ex) {
        }
        return buildings;
    }

    @Override
    public Building findById(Integer buNo) {
        Building building = null;
        ArrayList<BuInfo> buInfos = new ArrayList();
        try {
            String format = "SELECT * FROM %s";
            String query = String.format(format, "BUILDING");
            rs = stat.executeQuery(query);
            while (rs.next()) {
                building = new Building(
                        rs.getInt("buNo"),
                        rs.getString("buName"),
                        rs.getString("buExplain"),
                        rs.getInt("buLocateX"),
                        rs.getString("buLocateY"),
                        rs.getString("buImage"),
                        rs.getInt("buFavo")
                );
            }
            String biFormat = "SELECT * FROM %s WHERE buNo = %d";
            query = String.format(biFormat, "BUINFO", building.getBuNo());
            Statement biStat = conn.createStatement();
            ResultSet rsTemp = biStat.executeQuery(query);
            while (rsTemp.next()) {
                BuInfo buInfo = new BuInfo(
                        rsTemp.getInt("buNo"),
                        rsTemp.getString("biFloor"),
                        rsTemp.getString("biName")
                );
                buInfos.add(buInfo);
            }
            building.setBuInfos(buInfos);
        } catch (SQLException ex) {
        }
        return building;
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
