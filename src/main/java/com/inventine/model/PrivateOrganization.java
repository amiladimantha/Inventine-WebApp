package com.inventine.model;

import com.inventine.util.DataValidator;


public class PrivateOrganization extends Organization {

    private String privateOrganizationId;
    private String organizationId;
    private String regNo;
    private DataValidator validator = new DataValidator();

    public String getRegNo() {
        return regNo;
    }

    public boolean setRegNo(String regNo) {
        this.validator.setTxt(regNo);
        this.validator.setMaxLength(10);

        if (this.validator.isAlphaNumeric()) {
            this.regNo = regNo;
            return true;
        }

        return false;
    }

    public String getPrivateOrganizationId() {
        return privateOrganizationId;
    }

    public boolean setPrivateOrganizationId(String privateOrganizationId) {
        this.validator.setTxt(privateOrganizationId);
        this.validator.setMaxLength(6);
        if (this.validator.isNumber()) {
            this.privateOrganizationId = privateOrganizationId;
            return true;
        }
        return false;
    }

    @Override
    public String getOrganizationId() {
        return organizationId;
    }

    @Override
    public boolean setOrganizationId(String organizationId) {
        this.validator.setTxt(organizationId);
        this.validator.setMaxLength(6);
        if (this.validator.isNumber()) {
            this.organizationId = organizationId;
            return true;
        }
        return false;
    }
}
