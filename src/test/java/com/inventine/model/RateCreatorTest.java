package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class RateCreatorTest {
    RateCreator rateCreator;

    @BeforeEach
    void setUp() {
        this.rateCreator = new RateCreator();
    }



    @ParameterizedTest
    @CsvFileSource(resources = "/model/RateCreator.csv", numLinesToSkip = 1)
    void getterSetter( String rate_creator_id, String creator_id, String investor_id, Timestamp created_at, int creator_rating) {

        this.rateCreator.setRateCreatorId(rate_creator_id);
        this.rateCreator.setCreatorId(creator_id);
        this.rateCreator.setInvestorId(investor_id);
        this.rateCreator.setCreatedAt(created_at);
        this.rateCreator.setCreatorRating(creator_rating);


        assertEquals(rate_creator_id,this.rateCreator.getRateCreatorId());
        assertEquals(creator_id, this.rateCreator.getCreatorId());
        assertEquals(investor_id, this.rateCreator.getInvestorId());
        assertEquals(created_at,this.rateCreator.getCreatedAt());
        assertEquals(creator_rating, this.rateCreator.getCreatorRating());

    }



}