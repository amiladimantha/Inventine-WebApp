package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Chat {

    private String chatId;
    private String receiverId;
    private String senderId;
    private String message;
    private Timestamp createdAt;
    private DataValidator validator = new DataValidator();

    public String getReceiverId() {
        return receiverId;
    }

    public boolean setReceiverId(String receiverId) {
        this.validator.setTxt(receiverId);
        this.validator.setMaxLength(6);
        if (this.validator.isNumber()) {

            this.receiverId = receiverId;
            return true;
        }
        return false;
      }

    public String getSenderId() {
        return senderId;
    }

    public boolean setSenderId(String senderId) {
        this.validator.setTxt(senderId);
        this.validator.setMaxLength(6);
        if (this.validator.isNumber()) {
            this.senderId = senderId;
            return true;
        }
        return false;
    }



    public String getChatId() {
        return chatId;
    }

    public boolean setChatId(String chatId) {

        this.validator.setTxt(chatId);
        this.validator.setMaxLength(6);


        if(this.validator.isNumber())
        {
            this.chatId = chatId;
            return true;
        }
        return false;

    }



    public String getMessage() {
        return message;
    }

    public boolean setMessage(String message) {

        this.message = message;
        return true;

    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public boolean setCreatedAt(Timestamp createdAt) {

        try{
        this.createdAt = createdAt;
        return true;
    } catch (Exception e) {
            return false;
        }

    }


}
