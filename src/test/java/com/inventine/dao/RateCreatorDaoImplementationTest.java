package com.inventine.dao;

import com.inventine.model.RateCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RateCreatorDaoImplementationTest {

    RateCreator rateCreator;
    RateCreatorDaoImplementation rateCreatorDao;
    @BeforeEach
    void setUp() {

        this.rateCreator = new RateCreator();
        this.rateCreatorDao = new RateCreatorDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(rateCreatorDao.getCount("creatorid=3"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/RateCreator.csv", numLinesToSkip = 1)
    void create( String rate_creator_id, String creator_id, String investor_id, Timestamp created_at, int creator_rating) {

        this.rateCreator.setRateCreatorId(rate_creator_id);
        this.rateCreator.setCreatorId(creator_id);
        this.rateCreator.setInvestorId(investor_id);
        this.rateCreator.setCreatorRating(creator_rating);
        this.rateCreator.setCreatedAt(created_at);

        assertTrue(this.rateCreatorDao.create(rateCreator));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/RateCreator.csv", numLinesToSkip = 1)
    void getRateCreator(String rate_creator_id, String creator_id, String investor_id, Timestamp created_at, int creator_rating) {

        this.rateCreator = this.rateCreatorDao.getRateCreator(rate_creator_id);

        assertEquals(rate_creator_id, this.rateCreator.getRateCreatorId());
        assertEquals(creator_id, this.rateCreator.getCreatorId());
        assertEquals(investor_id, this.rateCreator.getInvestorId());
        assertEquals(creator_rating, this.rateCreator.getCreatorRating());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/RateCreator.csv", numLinesToSkip = 1)
    void getRateCreators(String rate_creator_id, String creator_id, String investor_id, Timestamp created_at, int creator_rating) {

        List<RateCreator> ls = this.rateCreatorDao.getRateCreators("creatorid=3");

        this.rateCreator.setRateCreatorId(rate_creator_id);
        this.rateCreator.setCreatorId(creator_id);
        this.rateCreator.setInvestorId(investor_id);
        this.rateCreator.setCreatorRating(creator_rating);

        assertEquals(ls.get(0).getRateCreatorId(),this.rateCreator.getRateCreatorId());
        assertEquals(ls.get(0).getCreatorId(),this.rateCreator.getCreatorId());
        assertEquals(ls.get(0).getInvestorId(),this.rateCreator.getInvestorId());
        assertEquals(ls.get(0).getCreatorRating(),this.rateCreator.getCreatorRating());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/RateCreator.csv", numLinesToSkip = 1)
    void update(String rate_creator_id, String creator_id, String investor_id, Timestamp created_at, int creator_rating) {

        this.rateCreator.setRateCreatorId(rate_creator_id);
        this.rateCreator.setCreatorId(creator_id);
        this.rateCreator.setInvestorId(investor_id);
        this.rateCreator.setCreatorRating(creator_rating);


        this.rateCreatorDao.update(this.rateCreator);

        RateCreator updated = this.rateCreatorDao.getRateCreator(rate_creator_id);

        assertEquals(this.rateCreator.getRateCreatorId(),updated.getRateCreatorId());
        assertEquals(this.rateCreator.getCreatorId(),updated.getCreatorId());
        assertEquals(this.rateCreator.getInvestorId(),updated.getInvestorId());
        assertEquals(this.rateCreator.getCreatorRating(),updated.getCreatorRating());

    }

}