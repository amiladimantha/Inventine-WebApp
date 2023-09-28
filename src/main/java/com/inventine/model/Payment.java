package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Payment {

    private String paymentId;
    private String projectId;
    private String investorId;
    private String financialDetailsId;
    private int amount;
    private Timestamp createdAt;
    private String countSum;
    private DataValidator validator = new DataValidator();


    public String getPaymentId() {return paymentId;}

    public boolean setPaymentId(String paymentId) {
        this.validator.setTxt(paymentId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.paymentId = paymentId;
            return true;
        }

        return false;
    }

    public String getProjectId() {return projectId;}

    public boolean setProjectId(String projectId) {
        this.validator.setTxt(projectId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.projectId = projectId;
            return true;
        }

        return false;
    }

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

    public String getFinancialDetailsId() {return financialDetailsId;}

    public boolean setFinancialDetailsId(String financialDetailsId) {
        this.validator.setTxt(financialDetailsId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.financialDetailsId = financialDetailsId;
            return true;
        }

        return false;
    }

    public int getAmount() {
        return amount;
    }

    public boolean setAmount(int amount) {

        if (amount >= 0) {
            this.amount = amount;
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

        } catch (Exception e) {
            return true;
        }

        return false;
    }

    public String getCountSum() {
        return countSum;
    }

    public void setCountSum(String countSum) {
        this.countSum = countSum;
    }
}
