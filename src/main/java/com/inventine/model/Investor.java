package com.inventine.model;

import com.inventine.util.DataValidator;

public class Investor extends User{
    private String investorId;
    private String customerId;
    private DataValidator validator = new DataValidator();

    public String getInvestorId() {return investorId;}

    public boolean setInvestorId(String investorId) {
        this.validator.setTxt(investorId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.investorId = investorId;
            return true;
        }

        return false;
    }

    public String getCustomerId(){ return customerId;}

    public boolean setCustomerId(String customerId) {
        this.validator.setTxt(customerId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.customerId = customerId;
            return true;
        }

        return false;
    }
}
