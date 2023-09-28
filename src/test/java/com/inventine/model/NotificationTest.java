package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {

    Notification notification;

    @BeforeEach
    void setUp() {
        this.notification = new Notification();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Notification.csv", numLinesToSkip = 1)
    void getterSetter(String notificationId, String type,String message, Timestamp created_at) {

        this.notification.setNotificationId(notificationId);
        this.notification.setType(type);
        this.notification.setMessage(message);
        this.notification.setCreatedAt(created_at);


        assertEquals(notificationId,this.notification.getNotificationId());
        assertEquals(type,this.notification.getType());
        assertEquals(message,this.notification.getMessage());
        assertEquals(created_at,this.notification.getCreatedAt());




    }





}