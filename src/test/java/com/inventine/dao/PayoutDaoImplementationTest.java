package com.inventine.dao;

import com.inventine.model.Payout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PayoutDaoImplementationTest {
    Payout payout;
    PayoutDaoImplementation payoutDao;

    @BeforeEach
    void setUp() {
        this.payout = new Payout();
        this.payoutDao = new PayoutDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(payoutDao.getCount("transactionid=123"),1);
    }

    @Test
    void  getCountAmount(){assertEquals(payoutDao.getCountAmount("transactionid=123"),20000);}

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payout.csv", numLinesToSkip = 1)
    void create(String financeDetailsId,String financeAdminId ,int amount , String transactionId, Timestamp created_at) {

        this.payout.setFinanceDetailsId(financeDetailsId);
        this.payout.setFinanceAdminId(financeAdminId);
        this.payout.setTransactionId(transactionId);
        this.payout.setAmount(amount);




        assertTrue(this.payoutDao.create(payout));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payout.csv", numLinesToSkip = 1)
    void getPayout(String financeDetailsId,String financeAdminId ,int amount , String transactionId, Timestamp created_at) {

        this.payout = this.payoutDao.getPayout(transactionId);

        assertEquals(financeDetailsId, this.payout.getFinanceDetailsId());
        assertEquals(financeAdminId, this.payout.getFinanceAdminId());
        assertEquals(amount, this.payout.getAmount());
        assertEquals(transactionId, this.payout.getTransactionId());

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payout.csv", numLinesToSkip = 1)
    void getPayouts(String financeDetailsId,String financeAdminId ,int amount , String transactionId, Timestamp created_at) {

        List<Payout> ls = this.payoutDao.getPayouts("transactionid=123");

        this.payout.setFinanceDetailsId(financeDetailsId);
        this.payout.setFinanceAdminId(financeAdminId);
        this.payout.setAmount(amount);
        this.payout.setTransactionId(transactionId);
        this.payout.setCreatedAt(created_at);

        assertEquals(ls.get(0).getFinanceDetailsId(),this.payout.getFinanceDetailsId());
        assertEquals(ls.get(0).getFinanceAdminId(),this.payout.getFinanceAdminId());
        assertEquals(ls.get(0).getAmount(),this.payout.getAmount());
        assertEquals(ls.get(0).getTransactionId(),this.payout.getTransactionId());
        assertEquals(ls.get(0).getCreatedAt(),this.payout.getCreatedAt());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Payout.csv", numLinesToSkip = 1)
    void update(String financeDetailsId,String financeAdminId ,int amount , String transactionId, Timestamp created_at) {

        this.payout.setFinanceDetailsId(financeDetailsId);
        this.payout.setFinanceAdminId(financeAdminId);
        this.payout.setAmount(amount);
        this.payout.setTransactionId(transactionId);

        this.payoutDao.update(this.payout);

        Payout updated = this.payoutDao.getPayout(transactionId);

        assertEquals(this.payout.getFinanceDetailsId(),updated.getFinanceDetailsId());
        assertEquals(this.payout.getFinanceAdminId(),updated.getFinanceAdminId());
        assertEquals(this.payout.getAmount(),updated.getAmount());
        assertEquals(this.payout.getTransactionId(),updated.getTransactionId());

    }


}
