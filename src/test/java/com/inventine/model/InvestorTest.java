package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class InvestorTest {
    Investor investor;

    @BeforeEach
    void setUp() {
        this.investor = new Investor();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Investor.csv", numLinesToSkip = 1)
    void getterSetter(String investor_id, String customer_id) {

        this.investor.setInvestorId(investor_id);
        this.investor.setCustomerId(customer_id);

        assertEquals(investor_id, this.investor.getInvestorId());
        assertEquals(customer_id, this.investor.getCustomerId());

    }
}