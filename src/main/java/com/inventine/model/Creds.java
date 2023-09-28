package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Creds {

    private String userId;
    private String username;
    private String email;
    private String password;
    private char role;
    private char status;
    private Timestamp createdAt;

    private String profileId;

    private DataValidator validator = new DataValidator();

    public String getUserId(){
        return userId;
    }

    public boolean setUserId(String userId) {


        this.userId = userId;
        return true;

    }

    public String getUsername(){
        return username;
    }

    public boolean setUsername(String username) {

        this.validator.setTxt(username);

        this.validator.setMinLength(4);
        this.validator.setMaxLength(50);

        if (this.validator.isAlphaNumeric()) {
            this.username = username;
            return true;
        }

        return false;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {

        this.validator.setTxt(email);

        if (this.validator.isEmail()) {
            this.email = email;
            return true;
        }

        return false;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {

        this.validator.setTxt(password);

        if (this.validator.isSHA256()) {
            this.password = password;
            return true;
        }

        return false;
    }

    public char getRole() {
        return role;
    }

    public boolean setRole(char role) {

        if (role == 'A' || role == 'C' || role == 'I'|| role == 'F' || role == 'S' || role == 'O' ) {
            this.role = role;
            return true;
        }

        return false;
    }

    public char getStatus() {
        return status;
    }

    public boolean setStatus(char status) {

        if (status == 'U' || status == 'A' || status == 'B'|| status == 'D') {
            this.status = status;
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

    public String getProfileId(){
        return profileId;
    }

    public boolean setProfileId(String profileId) {

        this.validator.setTxt(profileId);

        if (this.validator.isNumber()) {
            this.profileId = profileId;
            return true;
        }

        return false;
    }

}