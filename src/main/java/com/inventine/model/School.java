package com.inventine.model;

import com.inventine.util.DataValidator;

public class School extends Organization{
    private  String schoolId;
    private  String  organizationId;
    private DataValidator validator = new DataValidator();


    public String getSchoolId() {
        return schoolId;
    }

   @Override
    public String getOrganizationId() {
        return organizationId;
    }



    public boolean setSchoolId(String schoolId) {

        this.validator.setTxt(schoolId);
        this.validator.setMaxLength(6);

        if(this.validator.isNumber())
        {
            this.schoolId = schoolId;
            return true;
        }
        return false;
    }

    @Override
    public boolean setOrganizationId(String organizationId) {
        this.validator.setTxt(organizationId);
        this.validator.setMaxLength(6);
        if(this.validator.isNumber())
        {
            this.organizationId = organizationId;
            return true;
        }
        return false;


    }



}
