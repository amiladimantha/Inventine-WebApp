package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class PayoutTest {
    Payout payout;

    @BeforeEach
    void setUp() {
        this.payout = new Payout();
    }



    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payout.csv", numLinesToSkip = 1)
    void getterSetter(String finance_details_id, String finance_admin_id,int amount, String transaction_id, Timestamp created_at) {

        this.payout.setFinanceDetailsId(finance_details_id);
        this.payout.setFinanceAdminId(finance_admin_id);
        this.payout.setAmount(amount);
        this.payout.setTransactionId(transaction_id);
        this.payout.setCreatedAt(created_at);


        assertEquals(finance_details_id,this.payout.getFinanceDetailsId());
        assertEquals(finance_admin_id,this.payout.getFinanceAdminId());
        assertEquals(amount,this.payout.getAmount());
        assertEquals(transaction_id,this.payout.getTransactionId());
        assertEquals(created_at,this.payout.getCreatedAt());




    }



}