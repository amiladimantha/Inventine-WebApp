package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Refund {

    private String refundId;
    private String financeAdminId;
    private String paymentId;
    private Timestamp createdAt;
    private DataValidator validator = new DataValidator();

    public String getRefundId() {
        return refundId;
    }

    public boolean setRefundId(String refundId) {

        this.validator.setTxt(refundId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.refundId = refundId;
            return true;
        }

        return false;


    }

    public String getFinanceAdminId() {
        return financeAdminId;
    }

    public boolean setFinanceAdminId(String financeAdminId) {
        this.validator.setTxt(financeAdminId);
        if(this.validator.isNumber()) {
            this.financeAdminId = financeAdminId;
            return true;
        }
        return false;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public boolean setPaymentId(String paymentId) {

        this.validator.setTxt(paymentId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.paymentId = paymentId;
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

}


