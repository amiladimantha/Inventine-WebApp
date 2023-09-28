package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Organization {
    private String organizationId;
    private String SupportTeamId;
    private String name;
    private String address;
    private String district;
    private String contactNumber;
    private Timestamp createdAt;
    private String logoId;
    private String headerId;
    private char orgType;
    private DataValidator validator = new DataValidator();

    public String getLogoId() {
        return logoId;
    }

    public boolean setLogoId(String logoId) {



            this.logoId = logoId;
            return  true;


    }

    public String getHeaderId() {
        return headerId;
    }

    public boolean setHeaderId(String headerId) {


            this.headerId = headerId;
            return true;




    }

    public String getOrganizationId() {
        return organizationId;
    }

    public boolean setOrganizationId(String organizationId) {

        this.organizationId = organizationId;
        return true;
    }

    public String getSupportTeamId() {
        return SupportTeamId;
    }

    public boolean setSupportTeamId(String supportTeamId) {
        this.validator.setTxt(supportTeamId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            SupportTeamId = supportTeamId;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        this.name = name;

        return true;
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        this.validator.setTxt(address);


        if (this.validator.isAddress()) {
            this.address = address;
            return true;
        }

        return false;
    }

    public String getDistrict() {
        return district;
    }

    public boolean setDistrict(String district) {
        this.validator.setTxt(district);
        this.validator.setMinLength(5);
        this.validator.setMaxLength(12);

        if (this.validator.isString()) {
            this.district = district;
            return true;
        }

        return false;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public boolean setContactNumber(String contactNumber) {
        this.validator.setTxt(contactNumber);


        if (this.validator.isPhone()) {
            this.contactNumber = contactNumber;
            return true;
        }

        return false;
    }


    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public boolean setCreatedAt(Timestamp createdAt) {
        try {
            this.createdAt = createdAt;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public char getOrgType() {
        return orgType;
    }

    public boolean setOrgType(char orgType) {
        if (orgType == 'S' || orgType == 'U'|| orgType=='P') {
            this.orgType = orgType;
            return true;
        }

        return false;

    }




}
