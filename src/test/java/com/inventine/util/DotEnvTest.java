package com.inventine.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DotEnvTest {

    DotEnv dotEnv;


    @ParameterizedTest
    @CsvFileSource(resources = "/util/DotEnv/load.csv", numLinesToSkip = 1)
    void load(String key, String value) {

        Map<String,String> env = DotEnv.load();

        System.out.println(value);
        assertEquals(key,env.get(key));
    }
}