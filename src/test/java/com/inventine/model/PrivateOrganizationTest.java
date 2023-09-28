package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrivateOrganizationTest {
    PrivateOrganization privateOrganization;

    @BeforeEach
    void setUp() {
        this.privateOrganization = new PrivateOrganization();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/PrivateOrganization.csv", numLinesToSkip = 1)
    void getterSetter(String private_organization_id,String organization_id,String reg_no) {
        this.privateOrganization.setPrivateOrganizationId(private_organization_id);
        this.privateOrganization.setOrganizationId(organization_id);
        this.privateOrganization.setRegNo(reg_no);

        assertEquals(private_organization_id,this.privateOrganization.getPrivateOrganizationId());
        assertEquals(organization_id,this.privateOrganization.getOrganizationId());
        assertEquals(reg_no, this.privateOrganization.getRegNo());
    }
}
