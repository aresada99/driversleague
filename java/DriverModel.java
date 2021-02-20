package com.example.driverleague;

public class DriverModel {


    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone_num;
    private String car_make;
    private String car_model;

    // Constructors


    public DriverModel(int id, String name, String surname, String email, String password, String phone_num, String car_make, String car_model) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phone_num = phone_num;
        this.car_make = car_make;
        this.car_model = car_model;
    }

    public DriverModel() {
    }

    // toString

    @Override
/*    public String toString() {
        return "DriverModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", car_make='" + car_make + '\'' +
                ", car_model='" + car_model + '\'' +
                '}';
    }*/

    public String toString(){
        String pnum;
        String car;
        if(phone_num.equals("")){
            pnum = "None";
        }
        else{
            pnum = phone_num;
        }
        if(car_make.equals("")){
            car = "None";
        }
        else{car = car_make + " " + car_model;}


        return "ID: "+ id +"   Name & Surname: " + name + " " + surname + "   E-Mail: " + email + "   Password: " + password + "   Phone Num: " + pnum + "   Car: " + car;
    }

    // Getters & Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getCar_make() {
        return car_make;
    }

    public void setCar_make(String car_make) {
        this.car_make = car_make;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }
}
