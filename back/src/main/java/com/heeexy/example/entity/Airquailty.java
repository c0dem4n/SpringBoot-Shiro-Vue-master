package com.heeexy.example.entity;

import java.util.Date;

/**
 * Created by wzq
 */
public class Airquailty {
    @Override
    public String toString() {
        return "Airquailty{" +
                "id=" + id +
                ", communityName='" + communityName + '\'' +
                ", communityId=" + communityId +
                ", airdate='" + airdate + '\'' +
                ", hour=" + hour +
                ", pm2_5=" + pm2_5 +
                ", pm10=" + pm10 +
                ", so2=" + so2 +
                ", no2=" + no2 +
                ", o3=" + o3 +
                ", co=" + co +
                '}';
    }

    private int id;
    private String communityName;
    private int communityId;
    private Date airdate;
    private int hour;
    private int pm2_5;
    private int pm10;
    private int so2;
    private int no2;
    private int o3;
    private int co;

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

    public Date getAirdate() {
        return airdate;
    }

    public void setAirdate(Date airdate) {
        this.airdate = airdate;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(int pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getSo2() {
        return so2;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }

    public int getCo() {
        return co;
    }

    public void setCo(int co) {
        this.co = co;
    }
}
