package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniversityTest {
    University university;

    @BeforeEach
    void setUp() {
        this.university = new University();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/University.csv", numLinesToSkip = 1)
    void getterSetter(String university_id,String organization_id,String email) {

        this.university.setUniversityId(university_id);
        this.university.setOrganizationId(organization_id);
        this.university.setEmail(email);

        assertEquals(university_id,this.university.getUniversityId());
        assertEquals(organization_id,this.university.getOrganizationId());
        assertEquals(email, this.university.getEmail());

    }
}
