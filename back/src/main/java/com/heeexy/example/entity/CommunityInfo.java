package com.heeexy.example.entity;

/**
 * Created by wzq
 */
public class CommunityInfo {
    private int id;
    private String communityName;
    private int communityId;
    private double mianji;
    private double rongjilv;
    private double lvhualv;
    private int house;
    private String wuyetel;
    private String wuyeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public double getMianji() {
        return mianji;
    }

    public void setMianji(double mianji) {
        this.mianji = mianji;
    }

    public double getRongjilv() {
        return rongjilv;
    }

    public void setRongjilv(double rongjilv) {
        this.rongjilv = rongjilv;
    }

    public double getLvhualv() {
        return lvhualv;
    }

    public void setLvhualv(double lvhualv) {
        this.lvhualv = lvhualv;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public String getWuyetel() {
        return wuyetel;
    }

    public void setWuyetel(String wuyetel) {
        this.wuyetel = wuyetel;
    }

    public String getWuyeName() {
        return wuyeName;
    }

    public void setWuyeName(String wuyeName) {
        this.wuyeName = wuyeName;
    }

    @Override
    public String toString() {
        return "CommunityInfo{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", communityId=" + communityId +
                ", mianji=" + mianji +
                ", rongjilv=" + rongjilv +
                ", lvhualv=" + lvhualv +
                ", house=" + house +
                ", wuyetel='" + wuyetel + '\'' +
                ", wuyeName='" + wuyeName + '\'' +
                '}';
    }
}
