package com.inventine.model;

import com.inventine.util.DataValidator;

public class SupportTeam extends Employee{
    private String supportTeamId;
    private String employeeId;
    private DataValidator validator = new DataValidator();

    public String getSupportTeamId() {
        return supportTeamId;
    }

    public boolean setSupportTeamId(String supportTeamId) {
        this.validator.setTxt(supportTeamId);
        this.validator.setMaxLength(6);
        if(this.validator.isNumber()){
            this.supportTeamId = supportTeamId;
            return true;
        }
        return false;
    }


    public String getEmployeeId() {
        return employeeId;
    }


    public boolean setEmployeeId(String employeeId) {
        this.validator.setTxt(employeeId);
        this.validator.setMaxLength(6);
        if(this.validator.isNumber()){
            this.employeeId = employeeId;
            return true;
        }
        return false;
    }
}
