package com.inventine.dao;

import com.inventine.model.Investor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvestorDaoImplementationTest {

    Investor investor;
    InvestorDaoImplementation investorDao;
    @BeforeEach
    void setUp() {

        this.investor = new Investor();
        this.investorDao = new InvestorDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(investorDao.getCount("investorid=1"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Investor.csv", numLinesToSkip = 1)
    void create(String investor_id,String customer_id) {

        this.investor.setInvestorId(investor_id);
        this.investor.setCustomerId(customer_id);



        assertTrue(this.investorDao.create(investor));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Investor.csv", numLinesToSkip = 1)
    void getInvestor(String investor_id,String customer_id) {

        this.investor = this.investorDao.getInvestor(investor_id);

        assertEquals(investor_id, this.investor.getInvestorId());
        assertEquals(customer_id, this.investor.getCustomerId());

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Investor.csv", numLinesToSkip = 1)
    void getInvestors(String investor_id,String customer_id) {

        List<Investor> ls = this.investorDao.getInvestors("investorid=1");

        this.investor.setInvestorId(investor_id);
        this.investor.setCustomerId(customer_id);


        assertEquals(ls.get(0).getInvestorId(),this.investor.getInvestorId());
        assertEquals(ls.get(0).getCustomerId(),this.investor.getCustomerId());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Investor.csv", numLinesToSkip = 1)
    void update(String investor_id,String customer_id) {

        this.investor.setInvestorId(investor_id);
        this.investor.setCustomerId(customer_id);

        this.investorDao.update(this.investor);

        Investor updated = this.investorDao.getInvestor(investor_id);

        assertEquals(this.investor.getInvestorId(),updated.getInvestorId());
        assertEquals(this.investor.getCustomerId(),updated.getCustomerId());

    }

}