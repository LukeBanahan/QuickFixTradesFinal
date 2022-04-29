package com.example.quickfixtradesfinal;

public class Customer {
    private String fullName;
    private String phoneNumber;
    private String location;
    private String need;

    public Customer () {

    }

    public Customer(String fullName, String phoneNumber, String location, String need) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.need = need;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }
}
