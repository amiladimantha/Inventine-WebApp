package com.inventine.conf;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DBManagerTest {

    DBManager jdbc;

    @Test
    void testConnection(){

        jdbc = DBManager.getDbInstance();
        Connection conn =  jdbc.getConnection();

    }
}