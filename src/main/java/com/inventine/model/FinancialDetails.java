package com.inventine.model;

import com.inventine.util.DataValidator;

public class FinancialDetails {

    private String financialDetailsId;
    private String cardDetails;
    private String bankName;
    private String accountNo;
    private DataValidator validator = new DataValidator();

    public String getFinancialDetailsId() {

        return financialDetailsId;
    }

    public boolean setFinancialDetailsId(String financialDetailsId) {

        this.validator.setTxt(financialDetailsId);
        this.validator.setMaxLength(6);

        if(this.validator.isNumber())
        {
            this.financialDetailsId = financialDetailsId;
            return true;
        }
         return false;


    }

    public String getCardDetails() {
        return cardDetails;
    }

    public boolean setCardDetails(String cardDetails) {

        this.validator.setTxt(cardDetails);
        this.validator.setMaxLength(50);
        this.validator.setMinLength(3);

        if(this.validator.isAlphaNumeric())
        {
            this.cardDetails = cardDetails;
            return true;
        }
        return false;

    }

    public String getBankName() {
        return bankName;
    }

    public boolean setBankName(String bankName) {

        this.validator.setTxt(bankName);
        this.validator.setMaxLength(50);
        this.validator.setMinLength(3);
        if(this.validator.isString())
        {
            this.bankName = bankName;
            return true;
        }
          return false;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public boolean setAccountNo(String accountNo) {

        this.validator.setTxt(accountNo);
        this.validator.setMaxLength(50);
        this.validator.setMinLength(3);

        if(this.validator.isAlphaNumeric())
        {
            this.accountNo = accountNo;
            return  true;
        }
        return  false;

    }
}
