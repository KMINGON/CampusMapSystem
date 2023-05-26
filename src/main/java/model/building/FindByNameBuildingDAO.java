/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.building;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.DAO;
import model.DAODecorator;

/**
 *
 * @author LG
 */
public class FindByNameBuildingDAO extends DAODecorator<Building, Integer> {

    public FindByNameBuildingDAO(DAO dao) {
        super(dao);
    }

    public Building findByName(String buName) {
        Building building = null;
        ArrayList<BuInfo> buInfos = new ArrayList();
        try {
            String format = "SELECT * FROM %s WHERE buName = '%s'";
            String query = String.format(format, "BUILDING", buName);
            System.out.println(query);
            rs = stat.executeQuery(query);
            while (rs.next()) {
                building = new Building(
                        rs.getInt("buNo"),
                        rs.getString("buName"),
                        rs.getString("buExplain"),
                        rs.getInt("buLocateX"),
                        rs.getInt("buLocateY"),
                        rs.getString("buImage"),
                        rs.getInt("buFavo")
                );
            }
            if (building != null) {
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
            }
        } catch (SQLException ex) {
        }
        return building;
    }
}
