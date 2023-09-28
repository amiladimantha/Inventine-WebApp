package com.inventine.model;

import com.inventine.util.DataValidator;

public class Issues {

    private String issueId;
    private String userId;
    private String description;
    private char category;
    private char status;
    private String count;
    private DataValidator validator = new DataValidator();


    public String getIssueId() {
        return issueId;
    }

    public boolean setIssueId(String issueId) {
        this.validator.setTxt(issueId);
        if (this.validator.isNumber()){
            this.issueId = issueId;
            return true;
        }
        return false;
    }

    public char getCategory() {
        return category;
    }

    public boolean setCategory(char category) {

        if (category == 'P' || category == 'C' || category == 'R'){
            this.category = category;
            return true;
        }


        return false;
    }

    public String getUserId() {
        return userId;
    }

    public boolean setUserId(String userId) {
        this.validator.setTxt(userId);
        this.validator.setMaxLength(6);
        if(this.validator.isNumber()){
            this.userId = userId;
            return  true;
        }
        return false;
    }



    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        this.validator.setTxt(description);
        this.validator.setMaxLength(500);
        this.description = description;
        return true;
    }



    public char getStatus(){ return status;}

    public boolean setStatus(char status){

        if (status == 'A' || status == 'R' || status == 'B' || status == 'S') {
            this.status = status;
            return true;
        }

        return false;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}