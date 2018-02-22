package com.sampleapp.domain;

public class Address {
    private String apratmentNo;
    private String streetName;
    private String city;
    private int zipCode;
    private String state;

    public String getApratmentNo() {
        return apratmentNo;
    }

    public void setApratmentNo(String apratmentNo) {
        this.apratmentNo = apratmentNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
