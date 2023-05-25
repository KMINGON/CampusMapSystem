/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.boardData;

import java.sql.Timestamp;

/**
 *
 * @author LG
 */
public class BoardBuilder {

    private String userId;
    private String userName;
    private String bdTitle;
    private String bdContent;

    // Set optional attributes
    private Timestamp bdDate;
    private int bdViewCnt;
    private int bdBuildNum;
    private int bdNo;

    public BoardBuilder(String userId, String userName, String bdTitle, String bdContent) {
        this.userId = userId;
        this.userName = userName;
        this.bdTitle = bdTitle;
        this.bdContent = bdContent;
    }

    public BoardBuilder bdDate(Timestamp bdDate) {
        this.bdDate = bdDate;
        return this;
    }

    public BoardBuilder bdViewCnt(int bdViewCnt) {
        this.bdViewCnt = bdViewCnt;
        return this;
    }

    public BoardBuilder bdBuildNum(int bdBuildNum) {
        this.bdBuildNum = bdBuildNum;
        return this;
    }

    public BoardBuilder bdNo(int bdNo) {
        this.bdNo = bdNo;
        return this;
    }

    public Board build() {
        return new Board(this);
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getBdTitle() {
        return bdTitle;
    }

    public String getBdContent() {
        return bdContent;
    }

    public Timestamp getBdDate() {
        return bdDate;
    }

    public int getBdViewCnt() {
        return bdViewCnt;
    }

    public int getBdBuildNum() {
        return bdBuildNum;
    }

    public int getBdNo() {
        return bdNo;
    }

    
}
