package com.inventine.dao;

import com.inventine.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplementationTest {

    User user;
    UserDaoImplementation userDao;
    @BeforeEach
    void setUp() {

        this.user = new User();
        this.userDao = new UserDaoImplementation();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/User.csv", numLinesToSkip = 1)
    void create(String user_id, String first_name, String last_name, Timestamp dob, char gender, String phone,
                String address, String district, char type, Timestamp created_at) {

        this.user.setFirstName(first_name);
        this.user.setLastName(last_name);
        this.user.setDob(dob);
        this.user.setGender(gender);
        this.user.setPhone(phone);
        this.user.setAddress(address);
        this.user.setDistrict(district);
        this.user.setType(type);
        this.user.setCreatedAt(created_at);

        assertEquals(55,this.userDao.create(user));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/User.csv", numLinesToSkip = 1)
    void getUser(String user_id, String first_name, String last_name, Timestamp dob, char gender, String phone,
                 String address, String district, char type, Timestamp created_at) {

        this.user = this.userDao.getUser(user_id);

        assertEquals(user_id, this.user.getUserId());
        assertEquals(first_name, this.user.getFirstName());
        assertEquals(last_name, this.user.getLastName());
        assertEquals(dob, this.user.getDob());
        assertEquals(gender, this.user.getGender());
        assertEquals(phone, this.user.getPhone());
        assertEquals(address, this.user.getAddress());
        assertEquals(district, this.user.getDistrict());
        assertEquals(type, this.user.getType());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/User.csv", numLinesToSkip = 1)
    void getUsers(String user_id, String first_name, String last_name, Timestamp dob, char gender, String phone,
                  String address, String district, char type, Timestamp created_at) {

        List<User> ls = this.userDao.getUsers("");

        this.user.setUserId(user_id);
        this.user.setFirstName(first_name);
        this.user.setLastName(last_name);
        this.user.setDob(dob);
        this.user.setGender(gender);
        this.user.setPhone(phone);
        this.user.setAddress(address);
        this.user.setDistrict(district);
        this.user.setType(type);

        assertEquals(ls.get(0).getUserId(),this.user.getUserId());
        assertEquals(ls.get(0).getFirstName(),this.user.getFirstName());
        assertEquals(ls.get(0).getLastName(),this.user.getLastName());
        assertEquals(ls.get(0).getDob(),this.user.getDob());
        assertEquals(ls.get(0).getGender(),this.user.getGender());
        assertEquals(ls.get(0).getPhone(),this.user.getPhone());
        assertEquals(ls.get(0).getAddress(),this.user.getAddress());
        assertEquals(ls.get(0).getType(),this.user.getType());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/User.csv", numLinesToSkip = 1)
    void update(String user_id, String first_name, String last_name, Timestamp dob, char gender, String phone,
                String address, String district, char type, Timestamp created_at) {

        this.user.setUserId(user_id);
        this.user.setFirstName(first_name);
        this.user.setLastName(last_name);
        this.user.setDob(dob);
        this.user.setGender(gender);
        this.user.setPhone(phone);
        this.user.setAddress(address);
        this.user.setDistrict(district);
        this.user.setType('A');

        this.userDao.update(this.user);

        User updated = this.userDao.getUser(user_id);

        assertEquals(this.user.getUserId(),updated.getUserId());
        assertEquals(this.user.getFirstName(),updated.getFirstName());
        assertEquals(this.user.getLastName(),updated.getLastName());
        assertEquals(this.user.getDob(),updated.getDob());
        assertEquals(this.user.getGender(),updated.getGender());
        assertEquals(this.user.getPhone(),updated.getPhone());
        assertEquals(this.user.getAddress(),updated.getAddress());
        assertEquals('A',updated.getType());

    }

}