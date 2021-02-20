package com.example.driverleague;

public class DriverInfoModel {
    private String email;
    private String firm;
    private String chassisNo;
    private int avgSpeed;
    private String cruiseCtrl;
    private int brake;
    private int tonnage;
    private String idle;
    private float fuelAvg;
    private int km;

    // Constructors

    public DriverInfoModel(String email, String firm, String chassisNo, int avgSpeed, String cruiseCtrl, int brake, int tonnage, String idle, float fuelAvg, int km) {
        this.email = email;
        this.firm = firm;
        this.chassisNo = chassisNo;
        this.avgSpeed = avgSpeed;
        this.cruiseCtrl = cruiseCtrl;
        this.brake = brake;
        this.tonnage = tonnage;
        this.idle = idle;
        this.fuelAvg = fuelAvg;
        this.km = km;
    }

    public DriverInfoModel(){

    }

    // toString


    @Override
    public String toString() {
        return "DriverInfoModel{" +
                "email='" + email + '\'' +
                ", firm='" + firm + '\'' +
                ", chassisNo='" + chassisNo + '\'' +
                ", avgSpeed=" + avgSpeed +
                ", cruiseCtrl='" + cruiseCtrl + '\'' +
                ", brake=" + brake +
                ", tonnage=" + tonnage +
                ", idle='" + idle + '\'' +
                ", fuelAvg=" + fuelAvg +
                ", km=" + km +
                '}';
    }

    // Getters&Setters


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getChassisNo() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo = chassisNo;
    }

    public int getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(int avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public String getCruiseCtrl() {
        return cruiseCtrl;
    }

    public void setCruiseCtrl(String cruiseCtrl) {
        this.cruiseCtrl = cruiseCtrl;
    }

    public int getBrake() {
        return brake;
    }

    public void setBrake(int brake) {
        this.brake = brake;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    public String getIdle() {
        return idle;
    }

    public void setIdle(String idle) {
        this.idle = idle;
    }

    public float getFuelAvg() {
        return fuelAvg;
    }

    public void setFuelAvg(float fuelAvg) {
        this.fuelAvg = fuelAvg;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
