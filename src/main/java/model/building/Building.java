/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.building;

import java.util.ArrayList;

/**
 *
 * @author LG
 */
public class Building {

    int buNo;
    String buName;
    String buExplain;
    String buLocate;
    String buImage;
    int buFavo;
    ArrayList<BuInfo> buInfos;

    public Building(int buNo, String buName, String buExplain, String buLocate, String buImage, int buFavo) {
        this.buNo = buNo;
        this.buName = buName;
        this.buExplain = buExplain;
        this.buLocate = buLocate;
        this.buImage = buImage;
        this.buFavo = buFavo;
        this.buInfos = new ArrayList();
    }

    @Override
    public String toString() {
        return "buNo: " + buNo + " / "
                + "buName: " + buName + " / "
                + "buExplain: " + buExplain + " / "
                + "buLocate: " + buLocate + " / "
                + "buImage: " + buImage + " / "
                + "buFavo: " + buFavo + " / "
                + "buInfo: " + buInfoListToString();
    }

    private String buInfoListToString() {
        StringBuilder sb = new StringBuilder();
        for (BuInfo buinfo : buInfos) {
            sb.append(buinfo.toString()).append(" / ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 3); // 마지막 ' / ' 제거
        }
        return sb.toString();
    }

    public int getBuNo() {
        return buNo;
    }

    public void setBuNo(int buNo) {
        this.buNo = buNo;
    }

    public String getBuName() {
        return buName;
    }

    public void setBuName(String buName) {
        this.buName = buName;
    }

    public String getBuExplain() {
        return buExplain;
    }

    public void setBuExplain(String buExplain) {
        this.buExplain = buExplain;
    }

    public String getBuLocate() {
        return buLocate;
    }

    public void setBuLocate(String buLocate) {
        this.buLocate = buLocate;
    }

    public String getBuImage() {
        return buImage;
    }

    public void setBuImage(String buImage) {
        this.buImage = buImage;
    }

    public int getBuFavo() {
        return buFavo;
    }

    public void setBuFavo(int buFavo) {
        this.buFavo = buFavo;
    }

    public ArrayList<BuInfo> getBuInfo() {
        return buInfos;
    }

    public void setBuInfo(ArrayList<BuInfo> buInfos) {
        this.buInfos = buInfos;
    }

}
