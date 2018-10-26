package com.a2599gmail.hari.sosmap;

import android.location.Location;

import java.util.ArrayList;

public class Request {
    private String id;
    private String name;
    private String phone;
    private boolean isFullfilled;
    private Location location;
    private ArrayList<String> imgURL;
    private String requestType;
    private String desc;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }



}
