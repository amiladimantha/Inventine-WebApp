package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Notification {

    private String notificationId;
    private String type;
    private String message;
    private Timestamp createdAt;
    private DataValidator validator = new DataValidator();


    public String getNotificationId() {
        return notificationId;
    }

    public boolean setNotificationId(String notificationId) {

        this.validator.setTxt(notificationId);
        this.validator.setMaxLength(6);
        this.validator.setMinLength(1);

        if(this.validator.isNumber())
        {
            this.notificationId = notificationId;
            return true;
        }


         return false;
    }

    public String getType() {
        return type;
    }

    public boolean setType(String type) {
        this.validator.setTxt(type);
        this.validator.setMaxLength(50);
        this.validator.setMinLength(6);

        if(this.validator.isEmail())
        {
            this.type = type;
            return true;
        }
        else
        {
            this.validator.setTxt(type);
            this.validator.setMaxLength(10);
            this.validator.setMinLength(10);
            if(this.validator.isNumber())
            {
                this.type = type;
                return true;
            }
        }

        return false;

     }

    public String getMessage() {
        return message;
    }

    public boolean setMessage(String message) {

        this.validator.setTxt(message);
        this.validator.setMaxLength(255);
        this.validator.setMinLength(2);


        if(this.validator.isAlphaNumeric())
        {
            this.message = message;
            return true;
        }
        return false;


    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public boolean setCreatedAt(Timestamp createdAt) {

        try
        {
            this.createdAt = createdAt;
        } catch(Exception e)

        {
            return  true;
        }
       return false;
    }
}
