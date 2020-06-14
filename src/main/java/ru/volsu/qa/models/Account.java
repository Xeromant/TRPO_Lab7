package ru.volsu.qa.models;

import lombok.*;

@Data
public class Account {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String dayBirth;
    private String monthBirth;
    private String yearBirth;

    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;

    public Account(String firstName, String lastName, String email, String password, String dayBirth,
                   String monthBirth, String yearBirth, String address, String city, String state,
                   String zip, String country, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dayBirth = dayBirth;
        this.monthBirth = monthBirth;
        this.yearBirth = yearBirth;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
    }

    public Account() {
        this.firstName = "Pav";
        this.lastName = "Pes";
        this.email = "randomemail@mail.com";
        this.password = "12345Password!";
        this.dayBirth = "1";
        this.monthBirth = "1";
        this.yearBirth = "2020";
        this.address = "myaddress";
        this.city = "Volgograd";
        this.state = "Texas";
        this.zip = "12345";
        this.country = "United States";
        this.phone = "8800553535";
    }

//    /*getters*/
//
//    public void setDayBirth(String dayBirth) {
//        this.dayBirth = dayBirth;
//    }
//
//    public void setMonthBirth(String monthBirth) {
//        this.monthBirth = monthBirth;
//    }
//
//    public void setYearBirth(String yearBirth) {
//        this.yearBirth = yearBirth;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public void setZip(String zip) {
//        this.zip = zip;
//    }
//
    public void setEmail(String email) {
        this.email = email;
    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    /*setters*/
//
//    public String getDayBirth() {
//        return dayBirth;
//    }
//
//    public String getMonthBirth() {
//        return monthBirth;
//    }
//
//    public String getYearBirth() {
//        return yearBirth;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public String getZip() {
//        return zip;
//    }
//
    public String getEmail() {
        return email;
    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
}
