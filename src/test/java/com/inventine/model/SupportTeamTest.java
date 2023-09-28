package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupportTeamTest {
    SupportTeam supportTeam;

    @BeforeEach
    void setUp() {
        this.supportTeam = new SupportTeam();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/SupportTeam.csv", numLinesToSkip = 1)
    void getterSetter(String employeeId,String supportTeamId) {

        this.supportTeam.setSupportTeamId(supportTeamId);
        this.supportTeam.setEmployeeId(employeeId);

        assertEquals(employeeId,this.supportTeam.getSupportTeamId());
        assertEquals(employeeId,this.supportTeam.getEmployeeId());


    }
}
