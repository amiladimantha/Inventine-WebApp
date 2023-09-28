package com.inventine.dao;

import com.inventine.model.Refund;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RefundDaoImplementationTest {

    Refund refund;
    RefundDaoImplementation refundDao;

    @BeforeEach
    void setUp() {
        this.refund = new Refund();
        this.refundDao = new RefundDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(refundDao.getCount("refundid=1"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Refund.csv", numLinesToSkip = 1)
    void create(String refundId,String financeAdminId , String paymentId, Timestamp created_at) {


        this.refund.setFinanceAdminId(financeAdminId);
        this.refund.setPaymentId(paymentId);


        assertTrue(this.refundDao.create(refund));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Refund.csv", numLinesToSkip = 1)
    void getPayout(String refundId,String financeAdminId , String paymentId, Timestamp created_at) {

        this.refund = this.refundDao.getRefund(refundId);

        assertEquals(refundId, this.refund.getRefundId());
        assertEquals(financeAdminId, this.refund.getFinanceAdminId());
        assertEquals(paymentId, this.refund.getPaymentId());
        assertEquals(created_at, this.refund.getCreatedAt());

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Refund.csv", numLinesToSkip = 1)
    void getPayouts(String refundId,String financeAdminId , String paymentId, Timestamp created_at) {

        List<Refund> ls = this.refundDao.getRefunds("refundId=7");

        this.refund.setRefundId(refundId);
        this.refund.setFinanceAdminId(financeAdminId);
        this.refund.setPaymentId(paymentId);
        this.refund.setCreatedAt(created_at);

        assertEquals(ls.get(0).getRefundId(),this.refund.getRefundId());
        assertEquals(ls.get(0).getFinanceAdminId(),this.refund.getFinanceAdminId());
        assertEquals(ls.get(0).getPaymentId(),this.refund.getPaymentId());
        assertEquals(ls.get(0).getCreatedAt(),this.refund.getCreatedAt());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Refund.csv", numLinesToSkip = 1)
    void update(String refundId,String financeAdminId , String paymentId, Timestamp created_at) {

        this.refund.setRefundId(refundId);
        this.refund.setFinanceAdminId(financeAdminId);
        this.refund.setPaymentId(paymentId);

        this.refundDao.update(this.refund);

        Refund updated = this.refundDao.getRefund(refundId);

        assertEquals(this.refund.getRefundId(),updated.getRefundId());
        assertEquals(this.refund.getFinanceAdminId(),updated.getFinanceAdminId());
        assertEquals(this.refund.getPaymentId(),updated.getPaymentId());

    }
}
