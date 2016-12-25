package com.example.tailoredtech.smartparking.models;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Daniyal on 12/25/2016.
 */

public class Parking implements Serializable {

    private String pid;
    private String pname;
    private String PImg;
    private Boolean isPremium;
    private String bikefare;
    private String carfare;
    private String mode;
    private Boolean isavail;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPImg() {
        return PImg;
    }

    public void setPImg(String PImg) {
        this.PImg = PImg;
    }

    public Boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Boolean isPremium) {
        this.isPremium = isPremium;
    }

    public String getBikefare() {
        return bikefare;
    }

    public void setBikefare(String bikefare) {
        this.bikefare = bikefare;
    }

    public String getCarfare() {
        return carfare;
    }

    public void setCarfare(String carfare) {
        this.carfare = carfare;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Boolean getIsavail() {
        return isavail;
    }

    public void setIsavail(Boolean isavail) {
        this.isavail = isavail;
    }

    public static Parking initialiseFromJSON(JSONObject response) {
        Gson gson = new Gson();
        String json = response.toString();
        Parking parking = gson.fromJson(json, Parking.class);
        return parking;
    }
}
