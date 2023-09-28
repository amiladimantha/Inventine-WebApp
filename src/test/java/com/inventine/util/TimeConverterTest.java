package com.inventine.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeConverterTest {

    TimeConverter tm = null;

    @BeforeEach
    void setUp() {
        tm = new TimeConverter();
    }

    @Test
    void stringToTimestamp() {
        System.out.println(tm.stringToTimestamp("2021-09-03 08:05:59"));
    }
}