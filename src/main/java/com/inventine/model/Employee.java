package com.inventine.model;

import com.inventine.util.DataValidator;

public class Employee extends User {

    private String employeeId;
    private String userId;
    private int nWorkHours;
    private int nTasks;
    private DataValidator validator = new DataValidator();

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


    public String getUserId() {
        return userId;
    }


    public boolean setUserId(String userId) {
        this.validator.setTxt(userId);
        this.validator.setMaxLength(6);
        if(this.validator.isNumber()){
            this.userId = userId;
            return true;
        }
        return false;
    }

    public int getNWorkHours() {
        return nWorkHours;
    }

    public void setNWorkHours(int nWorkHours) {
        this.nWorkHours = nWorkHours;
    }

    public int getNTasks() {
        return nTasks;
    }

    public void setNTasks(int nTasks) {
        this.nTasks = nTasks;
    }
}
