package com.inventine.model;

import com.inventine.util.DataValidator;

public class Credential {
    private String UserName;
    private char Role;
    private String Email;
    private String Password;
    private char Status;
    private String UserId;
    private DataValidator validator = new DataValidator();

    public String getUserName() {
        return UserName;
    }

    public boolean setUserName(String userName) {
        this.validator.setTxt(userName);
        if(this.validator.isAlphaNumeric()){
            this.UserName = userName;
            return true;
        }
        return false;
    }

    public char getRole() {
        return Role;
    }

    public boolean setRole(char role) {
        if(role == 'I'|| role == 'C' || role == 'S' || role == 'F' || role == 'A' ){
            this.Role = role;
            return true;
        }
        return false;
    }

    public String getEmail() {
        return Email;
    }

    public boolean setEmail(String email) {
        this.validator.setTxt(email);
        if(this.validator.isEmail()){
            this.Email = email;
            return true;
        }
        return false;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.validator.setTxt(password);
        this.validator.setMaxLength(50);
        this.Password = password;
    }

    public char getStatus() {
        return Status;
    }

    public boolean setStatus(char status) {
        if(status == 'A' || status == 'U' || status == 'B' || status == 'D'){
            this.Status = status;
            return true;
        }
        return false;
    }

    public String getUserId() {
        return UserId;
    }

    public boolean setUserId(String userId) {
        this.validator.setTxt(userId);
        if(this.validator.isNumber()){
            this.UserId = userId;
            return true;
        }
        return false;
    }
}
