package com.inventine.dao;

import com.inventine.model.Organization;
import com.inventine.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationDaoImplementationTest {

    Organization organization;
    OrganizationDaoImplementation organizationDao;

    @BeforeEach
    void setUp() {
        this.organization = new Organization();
        this.organizationDao = new OrganizationDaoImplementation();


    }


    @Test
    void getCount() {
        assertEquals(organizationDao.getCount("organizationid=60 "),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Organization.csv", numLinesToSkip = 1)
    void create(String organization_Id,String support_Team_Id, String name, String address , String district, String  contact_number,String created_at,String header_Id,String logo_Id,char org_type) {

        this.organization.setOrganizationId(organization_Id);
        this.organization.setSupportTeamId(support_Team_Id);
        this.organization.setName(name);
        this.organization.setAddress(address);
        this.organization.setDistrict(district);
        this.organization.setContactNumber(contact_number);
      //this.organization.setCreatedAt(created_at);

        this.organization.setHeaderId(header_Id);
        this.organization.setLogoId(logo_Id);
        this.organization.setOrgType(org_type);



        assertEquals(this.organizationDao.create(organization),0);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Organization.csv", numLinesToSkip = 1)
    void getOrganization(String organization_Id,String support_Team_Id, String name, String address , String district, String  contact_number,Timestamp created_at,String header_Id,String logo_Id,char org_type) {

        this.organization = this.organizationDao.getOrganization(organization_Id);

        assertEquals(organization_Id, this.organization.getOrganizationId());
        assertEquals(support_Team_Id, this.organization.getSupportTeamId());
        assertEquals(name, this.organization.getName());
        assertEquals(address, this.organization.getAddress());
        assertEquals(district,this.organization.getDistrict());
        assertEquals(contact_number, this.organization.getContactNumber());
       // assertEquals(created_at,this.organization.getCreatedAt());
        assertEquals(header_Id, this.organization.getHeaderId());
        assertEquals(logo_Id, this.organization.getLogoId());
        assertEquals(org_type,this.organization.getOrgType());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Organization.csv", numLinesToSkip = 1)
    void getOrganizations(String organization_Id,String support_Team_Id, String name, String address , String district, String  contact_number,Timestamp created_at,String header_Id,String logo_Id,char org_type) {

        List<Organization> ls = this.organizationDao.getOrganizations("");

        this.organization.setOrganizationId(organization_Id);
        this.organization.setSupportTeamId(support_Team_Id);
        this.organization.setName(name);
        this.organization.setAddress(address);
        this.organization.setDistrict(district);
        this.organization.setContactNumber(contact_number);
      //  this.organization.setCreatedAt(created_at);
        this.organization.setHeaderId(header_Id);
        this.organization.setLogoId(logo_Id);
        this.organization.setOrgType(org_type);



        assertEquals(ls.get(0).getOrganizationId(),this.organization.getOrganizationId());
        assertEquals(ls.get(0).getSupportTeamId(),this.organization.getSupportTeamId());
        assertEquals(ls.get(0).getName(),this.organization.getName());
        assertEquals(ls.get(0).getAddress(),this.organization.getAddress());
        assertEquals(ls.get(0).getDistrict(),this.organization.getDistrict());
        assertEquals(ls.get(0).getContactNumber(),this.organization.getContactNumber());
       // assertEquals(ls.get(0).getCreatedAt(),this.organization.getCreatedAt());
        assertEquals(ls.get(0).getHeaderId(),this.organization.getHeaderId());
        assertEquals(ls.get(0).getLogoId(),this.organization.getLogoId());
        assertEquals(ls.get(0).getOrgType(),this.organization.getOrgType());




    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Organization.csv", numLinesToSkip = 1)
    void update(String organization_Id,String support_Team_Id, String name, String address , String district, String  contact_number,Timestamp created_at,String header_Id,String logo_Id,char org_type) {

        this.organization.setOrganizationId(organization_Id);
        this.organization.setSupportTeamId(support_Team_Id);
        this.organization.setName(name);
        this.organization.setAddress(address);
        this.organization.setDistrict(district);
        this.organization.setContactNumber(contact_number);
     //   this.organization.setCreatedAt(created_at);
        this.organization.setHeaderId(header_Id);
        this.organization.setLogoId(logo_Id);
        this.organization.setOrgType(org_type);



        this.organizationDao.update(this.organization);

        Organization updated = this.organizationDao.getOrganization(organization_Id);

        assertEquals(this.organization.getOrganizationId(),updated.getOrganizationId());
        assertEquals(this.organization.getSupportTeamId(),updated.getSupportTeamId());
        assertEquals(this.organization.getName(),updated.getName());
        assertEquals(this.organization.getAddress(),updated.getAddress());
        assertEquals(this.organization.getDistrict(),updated.getDistrict());
        assertEquals(this.organization.getContactNumber(),updated.getContactNumber());
       // assertEquals(this.organization.getCreatedAt(),updated.getCreatedAt());
        assertEquals(this.organization.getHeaderId(),updated.getHeaderId());
        assertEquals(this.organization.getLogoId(),updated.getLogoId());
        assertEquals(this.organization.getOrgType(),updated.getOrgType());




    }



}