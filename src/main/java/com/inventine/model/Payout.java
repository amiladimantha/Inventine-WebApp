package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Payout {


    private String financeDetailsId;
    private String financeAdminId;
    private int amount;
    private String transactionId;
    private Timestamp createdAt;
    private DataValidator validator = new DataValidator();


    public String getFinanceDetailsId() {
        return financeDetailsId;
    }

    public boolean setFinanceDetailsId(String financeDetailsId) {
        this.validator.setTxt(financeDetailsId);
        if(this.validator.isNumber()){
            this.financeDetailsId = financeDetailsId;
            return true;
        }

        return false;
    }

    public String getFinanceAdminId() {
        return financeAdminId;
    }

    public boolean setFinanceAdminId(String financeAdminId) {
        this.validator.setTxt(financeAdminId);
        if(this.validator.isNumber()){
            this.financeAdminId = financeAdminId;
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

    public String getTransactionId() {
        return transactionId;
    }

    public boolean setTransactionId(String transactionId) {

        this.validator.setTxt(transactionId);
        this.validator.setMaxLength(20);

        if (this.validator.isNumber()) {
            this.transactionId = transactionId;
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
}
