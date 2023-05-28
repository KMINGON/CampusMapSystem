/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.boardData;

import java.sql.*;

/**
 *
 * @author LG
 */
public class Board {

    private String userId;
    private String userName;
    private String bdTitle;
    private String bdContent;
    private Timestamp bdDate;
    private int bdViewCnt;
    private int bdBuildNum;
    private int bdNo;

    public Board(String userId, String userName, String bdTitle, String bdContent, Timestamp bdDate, int bdViewCnt, int bdBuildNum, int bdNo) {
        this.userId = userId;
        this.userName = userName;
        this.bdTitle = bdTitle;
        this.bdContent = bdContent;
        this.bdDate = bdDate;
        this.bdViewCnt = bdViewCnt;
        this.bdBuildNum = bdBuildNum;
        this.bdNo = bdNo;
    }

    public Board(BoardBuilder builder) {
        this.userId = builder.getUserId();
        this.userName = builder.getUserName();
        this.bdTitle = builder.getBdTitle();
        this.bdContent = builder.getBdContent();
        this.bdDate = builder.getBdDate();
        this.bdViewCnt = builder.getBdViewCnt();
        this.bdBuildNum = builder.getBdBuildNum();
        this.bdNo = builder.getBdNo();
    }
    
    

    public int getBdBuildNum() {
        return bdBuildNum;
    }

    public void setBdBuildNum(int bdBuildNum) {
        this.bdBuildNum = bdBuildNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBdTitle() {
        return bdTitle;
    }

    public void setBdTitle(String bdTitle) {
        this.bdTitle = bdTitle;
    }

    public String getBdContent() {
        return bdContent;
    }

    public void setBdContent(String bdContent) {
        this.bdContent = bdContent;
    }

    public Timestamp getBdDate() {
        return bdDate;
    }

    public void setBdDate(Timestamp bdDate) {
        this.bdDate = bdDate;
    }

    public int getBdViewCnt() {
        return bdViewCnt;
    }

    public void setBdViewCnt(int bdViewCnt) {
        this.bdViewCnt = bdViewCnt;
    }

    public int getBdNo() {
        return bdNo;
    }

    public void setBdNo(int bdNo) {
        this.bdNo = bdNo;
    }

    @Override
    public String toString() {
        return "userId: " + userId + " \n "
                + "userName: " + userName + " \n "
                + "bdTitle: " + bdTitle + " \n "
                + "bdContent: " + bdContent + " \n "
                + "bdDate: " + bdDate + " \n "
                + "bdViewCnt: " + bdViewCnt + " \n "
                + "bdBuildNum: " + bdBuildNum + " \n "
                + "bdNo: " + bdNo;
    }
    
}
