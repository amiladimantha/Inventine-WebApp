package com.inventine.dao;

import com.inventine.model.Creds;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CredsDaoImplementationTest {

    Creds creds;
    CredsDaoImplementation credsDao;
    @BeforeEach
    void setUp() {

        this.creds = new Creds();
        this.credsDao = new CredsDaoImplementation();
    }

    @Test
    void getcount(){
        assertEquals(1,this.credsDao.getCount("email='testusername99'"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Creds.csv", numLinesToSkip = 1)
    void create(String userId, String username, String email,String password,
                char role, char status, String created_at) {

        assertTrue(this.creds.setUsername(username));
        assertTrue(this.creds.setEmail(email));
        assertTrue(this.creds.setPassword(password));
        assertTrue(this.creds.setRole(role));
        assertTrue(this.creds.setStatus(status));
        assertTrue(this.creds.setCreatedAt(Timestamp.valueOf(created_at)));

        assertEquals(this.credsDao.create(creds),0);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Creds.csv", numLinesToSkip = 1)
    void getCreds(String userId, String username, String email,String password,
                  char role, char status, String created_at) {

        this.creds = this.credsDao.getCreds("1");

        assertEquals(userId,this.creds.getUserId());
        assertEquals(username,this.creds.getUsername());
        assertEquals(email,this.creds.getEmail());
        assertEquals(password,this.creds.getPassword());
        assertEquals(role,this.creds.getRole());
        assertEquals(status,this.creds.getStatus());
        assertEquals(created_at,this.creds.getCreatedAt().toString());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Creds.csv", numLinesToSkip = 1)
    void getManyCreds(String userId, String username, String email,String password,
                   char role, char status, String created_at) {

        List<Creds> ls = this.credsDao.getManyCreds("userid=1");

        assertTrue(this.creds.setUserId(userId));
        assertTrue(this.creds.setUsername(username));
        assertTrue(this.creds.setEmail(email));
        assertTrue(this.creds.setPassword(password));
        assertTrue(this.creds.setRole(role));
        assertTrue(this.creds.setStatus(status));
        assertTrue(this.creds.setCreatedAt(Timestamp.valueOf(created_at)));

        assertEquals(userId,ls.get(0).getUserId());
        assertEquals(username,ls.get(0).getUsername());
        assertEquals(email,ls.get(0).getEmail());
        assertEquals(password,ls.get(0).getPassword());
        assertEquals(role,ls.get(0).getRole());
        assertEquals(status,ls.get(0).getStatus());
        assertEquals(created_at,ls.get(0).getCreatedAt().toString());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Creds.csv", numLinesToSkip = 1)
    void update(String userId, String username, String email,String password,
                char role, char status, String created_at) {

        char new_status = 'D';

        if( status == new_status){
            System.out.println("\nOld and new values should not be same!");
            return;
        }

        assertTrue(this.creds.setUserId(userId));
        assertTrue(this.creds.setUsername(username));
        assertTrue(this.creds.setEmail(email));
        assertTrue(this.creds.setPassword(password));
        assertTrue(this.creds.setRole(role));
        assertTrue(this.creds.setStatus(new_status));
        assertTrue(this.creds.setCreatedAt(Timestamp.valueOf(created_at)));

        // Update model with new attribute
        assertTrue(this.credsDao.update(this.creds));
        Creds updated = this.credsDao.getCreds(userId);

        assertEquals(userId,updated.getUserId());
        assertEquals(username,updated.getUsername());
        assertEquals(email,updated.getEmail());
        assertEquals(password,updated.getPassword());
        assertEquals(role,updated.getRole());
        assertEquals(new_status,updated.getStatus());
        assertEquals(created_at,updated.getCreatedAt().toString());

        // Counter update to rollback changes
        assertTrue(this.creds.setStatus(status));
        this.credsDao.update(this.creds);

    }

}