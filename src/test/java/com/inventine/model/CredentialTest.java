package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CredentialTest {
    Credential credential;

    @BeforeEach
    void setUp(){this.credential = new Credential();}

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Credential.csv", numLinesToSkip = 1)
    void getterSetter(String user_name, char role, String email, String password, char status, String user_id) {

        this.credential.setUserName(user_name);
        this.credential.setRole(role);
        this.credential.setEmail(email);
        this.credential.setPassword(password);
        this.credential.setStatus(status);
        this.credential.setUserId(user_id);

        assertEquals(user_name, this.credential.getUserName());
        assertEquals(role, this.credential.getRole());
        assertEquals(email, this.credential.getEmail());
        assertEquals(password, this.credential.getPassword());
        assertEquals(status, this.credential.getStatus());
        assertEquals(user_id, this.credential.getUserId());

    }
}
