package com.a2599gmail.hari.sosmap;

import android.location.Location;

import java.util.ArrayList;

public class Request {
    private String name;
    private boolean isFullfilled;
    private Location location;
    private ArrayList<String> imgURL;
    private ArrayList<String> requestType;
    private String desc;

    public Request(String name, boolean isFullfilled, ArrayList<String> requestType, String desc) {
        this.name = name;
        this.isFullfilled = isFullfilled;
        this.requestType = requestType;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFullfilled() {
        return isFullfilled;
    }

    public void setFullfilled(boolean fullfilled) {
        isFullfilled = fullfilled;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<String> getImgURL() {
        return imgURL;
    }

    public void setImgURL(ArrayList<String> imgURL) {
        this.imgURL = imgURL;
    }

    public ArrayList<String> getRequestType() {
        return requestType;
    }

    public void setRequestType(ArrayList<String> requestType) {
        this.requestType = requestType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



}
