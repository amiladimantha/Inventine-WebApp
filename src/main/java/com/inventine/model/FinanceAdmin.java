package com.inventine.model;

import com.inventine.util.DataValidator;

public class FinanceAdmin extends Employee{
    private String financeAdminId;
    private String employeeId;
    private DataValidator validator = new DataValidator();

    public String getFinanceAdminId() {
        return financeAdminId;
    }

    public boolean setFinanceAdminId(String financeAdminId) {
        this.validator.setTxt(financeAdminId);
        this.validator.setMaxLength(6);
        if(this.validator.isNumber()){
            this.financeAdminId = financeAdminId;
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
