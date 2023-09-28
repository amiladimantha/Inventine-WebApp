package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    School school;

    @BeforeEach
    void setUp() {
        this.school = new School();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/School.csv", numLinesToSkip = 1)
    void getterSetter(String school_Id,String organization_id) {

        this.school.setSchoolId(school_Id);
        this.school.setOrganizationId(organization_id);

        assertEquals(school_Id, this.school.getSchoolId());
        assertEquals(organization_id, this.school.getOrganizationId());

    }

}