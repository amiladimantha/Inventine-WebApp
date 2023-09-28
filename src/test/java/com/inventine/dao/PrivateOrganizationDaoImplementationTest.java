package com.inventine.dao;

import com.inventine.model.PrivateOrganization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrivateOrganizationDaoImplementationTest {

    PrivateOrganization privateOrganization;
    PrivateOrganizationDaoImplementation privateOrganizationDao;
    @BeforeEach
    void setUp() {

        this.privateOrganization = new PrivateOrganization();
        this.privateOrganizationDao = new PrivateOrganizationDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(privateOrganizationDao.getCount("privateOrganizationid=3"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/PrivateOrganization.csv", numLinesToSkip = 1)
    void create(String privateOrganization_id, String organization_id, String reg_no) {


        this.privateOrganization.setPrivateOrganizationId(privateOrganization_id);
        this.privateOrganization.setOrganizationId(organization_id);
        this.privateOrganization.setRegNo(reg_no);



        assertTrue(this.privateOrganizationDao.create(privateOrganization));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/PrivateOrganization.csv", numLinesToSkip = 1)
    void getPrivateOrganization(String privateOrganization_id,String organization_id,String reg_no) {

        this.privateOrganization = this.privateOrganizationDao.getPrivateOrganization(privateOrganization_id);

        assertEquals(privateOrganization_id, this.privateOrganization.getPrivateOrganizationId());
        assertEquals(organization_id, this.privateOrganization.getOrganizationId());
        assertEquals(reg_no, this.privateOrganization.getRegNo());


    }

    //
    @ParameterizedTest
    @CsvFileSource(resources = "/model/PrivateOrganization.csv", numLinesToSkip = 1)
    void getPrivateOrganizations(String privateOrganization_id,String organization_id,String reg_no) {

        List<PrivateOrganization> ls = this.privateOrganizationDao.getPrivateOrganizations("privateOrganizationid=1");

        this.privateOrganization.setPrivateOrganizationId(privateOrganization_id);
        this.privateOrganization.setOrganizationId(organization_id);
        this.privateOrganization.setRegNo(reg_no);


        assertEquals(ls.get(0).getPrivateOrganizationId(),this.privateOrganization.getPrivateOrganizationId());
        assertEquals(ls.get(0).getOrganizationId(),this.privateOrganization.getOrganizationId());
        assertEquals(ls.get(0).getRegNo(),this.privateOrganization.getRegNo());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/PrivateOrganization.csv", numLinesToSkip = 1)
    void update(String privateOrganization_id,String organization_id,String reg_no) {

        this.privateOrganization.setPrivateOrganizationId(privateOrganization_id);
        this.privateOrganization.setOrganizationId(organization_id);
        this.privateOrganization.setRegNo(reg_no);


        this.privateOrganizationDao.update(this.privateOrganization);

        PrivateOrganization updated = this.privateOrganizationDao.getPrivateOrganization(privateOrganization_id);

        assertEquals(this.privateOrganization.getPrivateOrganizationId(),updated.getPrivateOrganizationId());
        assertEquals(this.privateOrganization.getOrganizationId(),updated.getOrganizationId());
        assertEquals(this.privateOrganization.getRegNo(),updated.getRegNo());


    }

}