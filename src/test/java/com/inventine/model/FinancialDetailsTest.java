package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class FinancialDetailsTest {

    FinancialDetails financialDetails;

    @BeforeEach
    void setUp() {
        this.financialDetails = new FinancialDetails();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/FinancialDetails.csv", numLinesToSkip = 1)
    void getterSetter(String financialDetailsId, String cardDetails, String bankName, String accountNo) {

        this.financialDetails.setFinancialDetailsId(financialDetailsId);
        this.financialDetails.setCardDetails(cardDetails);
        this.financialDetails.setBankName(bankName);
        this.financialDetails.setAccountNo(accountNo);



        assertEquals(financialDetailsId,this.financialDetails.getFinancialDetailsId());
        assertEquals(cardDetails,this.financialDetails.getCardDetails());
        assertEquals(bankName,this.financialDetails.getBankName());
        assertEquals(accountNo,this.financialDetails.getAccountNo());












    }
}
