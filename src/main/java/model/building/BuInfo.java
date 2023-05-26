/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.building;

/**
 *
 * @author LG
 */
public class BuInfo {

    int buNo;
    String biFloor;
    String biName;

    public BuInfo(int buNo, String biFloor, String biName) {
        this.buNo = buNo;
        this.biFloor = biFloor;
        this.biName = biName;
    }

    @Override
    public String toString() {
        return "buNo: " + buNo + " / "
                + "biFloor: " + biFloor + " / "
                + "biName: " + biName;
    }

    public int getBuNo() {
        return buNo;
    }

    public void setBuNo(int buNo) {
        this.buNo = buNo;
    }

    public String getBiFloor() {
        return biFloor;
    }

    public void setBiFloor(String biFloor) {
        this.biFloor = biFloor;
    }

    public String getBiName() {
        return biName;
    }

    public void setBiName(String biName) {
        this.biName = biName;
    }

}
