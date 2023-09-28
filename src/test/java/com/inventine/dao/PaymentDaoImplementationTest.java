package com.inventine.dao;

import com.inventine.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentDaoImplementationTest {

    Payment payment;
    PaymentDaoImplementation paymentDao;
    @BeforeEach
    void setUp() {

        this.payment = new Payment();
        this.paymentDao = new PaymentDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(paymentDao.getCount("projectid=1"),2);
    }

    @Test
    void  getCountAmount(){
        assertEquals(paymentDao.getCountAmount("projectid=1"),20000);}

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payment.csv", numLinesToSkip = 1)
    void create(String payment_id, String project_id, String investor_id, String financial_details_id, int amount, Timestamp created_at) {

        this.payment.setPaymentId(payment_id);
        this.payment.setProjectId(project_id);
        this.payment.setInvestorId(investor_id);
        this.payment.setFinancialDetailsId(financial_details_id);
        this.payment.setAmount(amount);
        this.payment.setCreatedAt(created_at);

        assertTrue(this.paymentDao.create(payment));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payment.csv", numLinesToSkip = 1)
    void getPayment(String payment_id, String project_id, String investor_id, String financial_details_id, int amount, Timestamp created_at) {

        this.payment = this.paymentDao.getPayment(payment_id);
        
        assertEquals(payment_id, this.payment.getPaymentId());
        assertEquals(project_id, this.payment.getProjectId());
        assertEquals(investor_id, this.payment.getInvestorId());
        assertEquals(financial_details_id, this.payment.getFinancialDetailsId());
        assertEquals(amount, this.payment.getAmount());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payment.csv", numLinesToSkip = 1)
    void getPayments(String payment_id, String project_id, String investor_id, String financial_details_id, int amount, Timestamp created_at) {

        List<Payment> ls = this.paymentDao.getPayments("projectid=1");
        
        this.payment.setPaymentId(payment_id);
        this.payment.setProjectId(project_id);
        this.payment.setInvestorId(investor_id);
        this.payment.setFinancialDetailsId(financial_details_id);
        this.payment.setAmount(amount);

        
        assertEquals(ls.get(0).getPaymentId(),this.payment.getPaymentId());
        assertEquals(ls.get(0).getProjectId(),this.payment.getProjectId());
        assertEquals(ls.get(0).getInvestorId(),this.payment.getInvestorId());
        assertEquals(ls.get(0).getFinancialDetailsId(),this.payment.getFinancialDetailsId());
        assertEquals(ls.get(0).getAmount(),this.payment.getAmount());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payment.csv", numLinesToSkip = 1)
    void update(String payment_id, String project_id, String investor_id, String financial_details_id, int amount, Timestamp created_at) {


        this.payment.setPaymentId(payment_id);
        this.payment.setProjectId(project_id);
        this.payment.setInvestorId(investor_id);
        this.payment.setFinancialDetailsId(financial_details_id);
        this.payment.setAmount(amount);

        this.paymentDao.update(this.payment);

        Payment updated = this.paymentDao.getPayment(payment_id);

        assertEquals(this.payment.getPaymentId(),updated.getPaymentId());
        assertEquals(this.payment.getProjectId(),updated.getProjectId());
        assertEquals(this.payment.getInvestorId(),updated.getInvestorId());
        assertEquals(this.payment.getFinancialDetailsId(),updated.getFinancialDetailsId());
        assertEquals(this.payment.getAmount(),updated.getAmount());


    }

}