package com.inventine.model;

import com.inventine.util.DataValidator;

public class University extends Organization {

    private String universityId;
    private String organizationId;
    private String email;
    private DataValidator validator = new DataValidator();

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        this.validator.setTxt(email);
        this.validator.setMaxLength(50);


        if (this.validator.isEmail()) {
            this.email = email;
            return true;

        }

        return false;
    }

    public String getUniversityId() {
        return universityId;
    }

    public boolean setUniversityId(String universityId) {
        this.validator.setTxt(universityId);
        this.validator.setMaxLength(6);
        if (this.validator.isNumber()) {
            this.universityId = universityId;
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