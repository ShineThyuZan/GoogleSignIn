package com.example.googlesignin.Model;

public class DegreeDataModel {

    private String latitude;
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public DegreeDataModel(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
