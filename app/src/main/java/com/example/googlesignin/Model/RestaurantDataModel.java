package com.example.googlesignin.Model;

import com.google.gson.annotations.SerializedName;

public class RestaurantDataModel {


    private String id;

    @SerializedName("job-id")
    private String jobid;


    private String priority;


    private String company;

    private String address;

    private DegreeDataModel degreeDataModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DegreeDataModel getDegreeDataModel() {
        return degreeDataModel;
    }

    public void setDegreeDataModel(DegreeDataModel degreeDataModel) {
        this.degreeDataModel = degreeDataModel;
    }


    public RestaurantDataModel(String id, String jobid, String priority, String company,
                               String address, DegreeDataModel degreeDataModel) {
        this.id = id;
        this.jobid = jobid;
        this.priority = priority;
        this.company = company;
        this.address = address;
        this.degreeDataModel = degreeDataModel;
    }
}
