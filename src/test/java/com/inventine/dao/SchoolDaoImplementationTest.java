package com.inventine.dao;

import com.inventine.model.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchoolDaoImplementationTest {

    School school;
    SchoolDaoImplementation schoolDao;
    @BeforeEach

    void setUp() {

        this.school = new School();
        this.schoolDao = new SchoolDaoImplementation();
    }
    @Test
    void getCount() {
        assertEquals(schoolDao.getCount("organizationId=17"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/School.csv", numLinesToSkip = 1)
    void create( String school_id, String organization_id) {

        this.school.setSchoolId(school_id);
        this.school.setOrganizationId(organization_id);



        assertTrue(this.schoolDao.create(school));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/School.csv", numLinesToSkip = 1)
    void getSchool(String school_id,String organization_id) {

        this.school = this.schoolDao.getSchool(school_id);

        assertEquals(school_id, this.school.getSchoolId());
        assertEquals(organization_id, school.getOrganizationId());



    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/School.csv", numLinesToSkip = 1)
    void getSchools(String school_id, String organization_id ) {

        List<School> ls = this.schoolDao.getSchools("schoolId=22");

        this.school.setSchoolId(school_id);
        this.school.setOrganizationId(organization_id);




        assertEquals(ls.get(0).getSchoolId(),this.school.getSchoolId());
        assertEquals(ls.get(0).getOrganizationId(),this.school.getOrganizationId());



    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/School.csv", numLinesToSkip = 1)
    void update(String school_id, String organization_id ) {

        this.school.setSchoolId(school_id);
        this.school.setOrganizationId(organization_id);




        this.schoolDao.update(this.school);

        School updated = this.schoolDao.getSchool(school_id);

        assertEquals(this.school.getSchoolId(),updated.getSchoolId());
        assertEquals(this.school.getOrganizationId(),updated.getOrganizationId());



    }

}