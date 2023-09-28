package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/User.csv", numLinesToSkip = 1)
    void getterSetter(String user_id, String first_name, String last_name,Timestamp dob, char gender, String phone,
                      String address, String district, char type,  Timestamp created_at, String header_id) {

        this.user.setUserId(user_id);
        this.user.setFirstName(first_name);
        this.user.setLastName(last_name);
        this.user.setDob(dob);
        this.user.setGender(gender);
        this.user.setPhone(phone);
        this.user.setAddress(address);
        this.user.setDistrict(district);
        this.user.setType(type);
        this.user.setCreatedAt(created_at);
        this.user.setHeaderId(header_id);


        assertEquals(user_id, this.user.getUserId());
        assertEquals(first_name, this.user.getFirstName());
        assertEquals(last_name, this.user.getLastName());
        assertEquals(dob, this.user.getDob());
        assertEquals(gender, this.user.getGender());
        assertEquals(phone, this.user.getPhone());
        assertEquals(address, this.user.getAddress());
        assertEquals(district, this.user.getDistrict());
        assertEquals(type, this.user.getType());
        assertEquals(created_at, this.user.getCreatedAt());
        assertEquals(header_id, this.user.getHeaderId());
    }
}