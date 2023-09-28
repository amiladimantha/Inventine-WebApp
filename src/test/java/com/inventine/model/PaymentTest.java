package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    Payment payment;

    @BeforeEach
    void setUp() {
        this.payment = new Payment();
    }



    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payment.csv", numLinesToSkip = 1)
    void getterSetter(String payment_id, String project_id, String investor_id, String financial_details_id, int amount, Timestamp created_at) {

        this.payment.setPaymentId(payment_id);
        this.payment.setProjectId(project_id);
        this.payment.setInvestorId(investor_id);
        this.payment.setFinancialDetailsId(financial_details_id);
        this.payment.setAmount(amount);
        this.payment.setCreatedAt(created_at);


        assertEquals(payment_id, this.payment.getPaymentId());
        assertEquals(project_id, this.payment.getProjectId());
        assertEquals(investor_id, this.payment.getInvestorId());
        assertEquals(financial_details_id, this.payment.getFinancialDetailsId());
        assertEquals(amount,this.payment.getAmount());
        assertEquals(created_at,this.payment.getCreatedAt());




    }



}