package com.example.quickfixtradesfinal;

public class Worker {
    private String fullName;
    private String phoneNumber;
    private String location;
    private String skill;

    public Worker() {
        String fullName;
        String phoneNumber;
        String location;
        String skill;
    }

    public Worker(String fullName, String phoneNumber, String location, String skill) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.skill = skill;
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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
