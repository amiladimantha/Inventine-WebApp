package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class CredsTest {

    Creds creds;

    @BeforeEach
    void setUp() {
        this.creds = new Creds();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Creds.csv", numLinesToSkip = 1)
    void getterSetter(String userId, String username, String email,String password,
                      char role, char status, String created_at) {

        assertTrue(this.creds.setUserId(userId));
        assertTrue(this.creds.setUsername(username));
        assertTrue(this.creds.setEmail(email));
        assertTrue(this.creds.setPassword(password));
        assertTrue(this.creds.setRole(role));
        assertTrue(this.creds.setStatus(status));
        assertTrue(this.creds.setCreatedAt(Timestamp.valueOf(created_at)));

        assertEquals(userId,this.creds.getUserId());
        assertEquals(username,this.creds.getUsername());
        assertEquals(email,this.creds.getEmail());
        assertEquals(password,this.creds.getPassword());
        assertEquals(role,this.creds.getRole());
        assertEquals(status,this.creds.getStatus());
        assertEquals(created_at,this.creds.getCreatedAt().toString());

    }
}