package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class User {

    private String userId;
    private String firstName;
    private String lastName;
    private Timestamp dob;
    private char gender;
    private String phone;
    private String address;
    private String district;
    private char type;
    private Timestamp createdAt;

    private String headerId;

    private DataValidator validator = new DataValidator();

    public String getUserId(){
        return userId;
    }

    public boolean setUserId(String userId) {


        this.userId = userId;
        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {

        this.validator.setTxt(firstName);
        this.validator.setMinLength(2);
        this.validator.setMaxLength(50);

        if (this.validator.isString()) {
            this.firstName = firstName;
            return true;
        }

        return false;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {

        this.validator.setTxt(lastName);
        this.validator.setMinLength(2);
        this.validator.setMaxLength(50);

        if (this.validator.isString()) {
            this.lastName = lastName;
            return true;
        }

        return false;
    }

    public Timestamp getDob() {
        return dob;
    }

    public boolean setDob(Timestamp dob) {

        try {
            this.dob = dob;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public char getGender() {
        return gender;
    }

    public boolean setGender(char gender) {

        if (gender == 'M' || gender == 'F'|| gender == 'O') {
            this.gender = gender;
            return true;
        }

        return false;
    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {

        this.validator.setTxt(phone);

        if (this.validator.isPhone()) {
            this.phone = phone;
            return true;
        }

        return false;

    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {

        this.validator.setTxt(address);

        if (this.validator.isAddress()) {
            this.address = address;
            return true;
        }

        return false;
    }

    public String getDistrict() {
        return district;
    }

    public boolean setDistrict(String district) {

        this.validator.setTxt(district);
        this.validator.setMaxLength(12);

        if (this.validator.isString()) {
            this.district = district;
            return true;
        }

        return false;
    }

    public char getType() {
        return this.type;
    }

    public boolean setType(char type) {

        if (type == 'P' || type == 'A'|| type == 'S') {
            this.type = type;
            return true;
        }

        return false;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public boolean setCreatedAt(Timestamp createdAt) {

        try {
            this.createdAt = createdAt;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getHeaderId(){
        return headerId;
    }

    public boolean setHeaderId(String headerId) {

        this.validator.setTxt(headerId);
        this.validator.setMaxLength(20);

        if (this.validator.isNumber()) {
            this.headerId = headerId;
            return true;
        }

        return false;
    }

}
