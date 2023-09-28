package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class RefundTest {

    Refund refund;

    @BeforeEach
    void setUp() {
        this.refund = new Refund();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Refund.csv", numLinesToSkip = 1)
    void getterSetter(String refund_id, String payment_id, Timestamp created_at) {

        this.refund.setRefundId(refund_id);
        this.refund.setPaymentId(payment_id);
        this.refund.setCreatedAt(created_at);


        assertEquals(refund_id, this.refund.getRefundId());
        assertEquals(payment_id, this.refund.getPaymentId());
        assertEquals(created_at, this.refund.getCreatedAt());

    }
}