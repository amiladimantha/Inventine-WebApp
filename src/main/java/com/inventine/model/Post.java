package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Time;
import java.sql.Timestamp;

public class Post extends User{

    private String postId;
    private String description;
    private Timestamp createdAt;
    private Timestamp dateStr;
    private String userId;
    private DataValidator validator = new DataValidator();

    public Timestamp getDateStr() {
        return dateStr;
    }

    public void setDateStr(Timestamp dateStr) {
        this.dateStr = dateStr;
    }

    public String getPostId() {
        return postId;
    }

    public boolean setPostId(String postId) {
        this.validator.setTxt(postId);
        if(this.validator.isNumber()){
            this.postId = postId;
            return true;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public boolean setCreatedAt(Timestamp createdAt) {
        try{
            this.createdAt = createdAt;
            return true;
        }catch(Exception e )
        {
            return false;
        }
    }

    public String getUserId() {
        return userId;
    }

    public boolean setUserId(String userId) {
        this.validator.setTxt(userId);
        if(this.validator.isNumber()){
            this.userId = userId;
            return true;
        }
        return false;
    }
}