package com.hudutech.nazarenelostfoundapp;

import java.util.Date;

public class LostItem implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String itemName;
    private String itemDesc;
    private String location;
    private String locationInfo;
    private double lat;
    private double lng;
    private Date dateLost;
    //for demo purpose only
    //for actual we will use with image url
    private int resId;
    private String imageUrl;

    public LostItem() {}

    public LostItem(String itemName, String itemDesc, String location, String locationInfo, double lat, double lng, Date dateLost, int resId, String imageUrl) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.location = location;
        this.locationInfo = locationInfo;
        this.lat = lat;
        this.lng = lng;
        this.dateLost = dateLost;
        this.resId = resId;
        this.imageUrl = imageUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public Date getDateLost() {
        return dateLost;
    }

    public void setDateLost(Date dateLost) {
        this.dateLost = dateLost;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
