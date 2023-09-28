package com.inventine.dao;

import com.inventine.model.University;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniversityDaoImplementationTest {

    University university;
    UniversityDaoImplementation universityDao;
    @BeforeEach
    void setUp() {

        this.university = new University();
        this.universityDao = new UniversityDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(universityDao.getCount("universityid=3"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/University.csv", numLinesToSkip = 1)
    void create(String university_id, String organization_id, String email) {


        this.university.setUniversityId(university_id);
        this.university.setOrganizationId(organization_id);
        this.university.setEmail(email);



        assertTrue(this.universityDao.create(university));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/University.csv", numLinesToSkip = 1)
    void getUniversity(String university_id, String organization_id, String email) {

        this.university = this.universityDao.getUniversity(university_id);

        assertEquals(university_id, this.university.getUniversityId());
        assertEquals(organization_id, this.university.getOrganizationId());
        assertEquals(email, this.university.getEmail());


    }

    //
    @ParameterizedTest
    @CsvFileSource(resources = "/model/University.csv", numLinesToSkip = 1)
    void getUniversitys(String university_id, String organization_id, String email) {

        List<University> ls = this.universityDao.getUniversitys("universityid=1");

        this.university.setUniversityId(university_id);
        this.university.setOrganizationId(organization_id);
        this.university.setEmail(email);


        assertEquals(ls.get(0).getUniversityId(),this.university.getUniversityId());
        assertEquals(ls.get(0).getOrganizationId(),this.university.getOrganizationId());
        assertEquals(ls.get(0).getEmail(),this.university.getEmail());


    }
    //
    @ParameterizedTest
    @CsvFileSource(resources = "/model/University.csv", numLinesToSkip = 1)
    void update(String university_id, String organization_id, String email) {

        this.university.setUniversityId(university_id);
        this.university.setOrganizationId(organization_id);
        this.university.setEmail(email);


        this.universityDao.update(this.university);

        University updated = this.universityDao.getUniversity(university_id);

        assertEquals(this.university.getUniversityId(),updated.getUniversityId());
        assertEquals(this.university.getOrganizationId(),updated.getOrganizationId());
        assertEquals(this.university.getEmail(),updated.getEmail());


    }

}