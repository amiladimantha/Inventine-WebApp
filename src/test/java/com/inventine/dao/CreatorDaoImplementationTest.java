package com.inventine.dao;

import com.inventine.model.Creator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreatorDaoImplementationTest {

    Creator creator;
    CreatorDaoImplementation creatorDao;
    @BeforeEach
    void setUp() {

        this.creator = new Creator();
        this.creatorDao = new CreatorDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(creatorDao.getCount("creatorid=3"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Creator.csv", numLinesToSkip = 1)
    void create(String creator_id,String customer_id,String support_team_id) {


        this.creator.setCustomerId(customer_id);
        this.creator.setSupportTeamId(support_team_id);


        assertTrue(this.creatorDao.create(creator));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Creator.csv", numLinesToSkip = 1)
    void getCreator(String creator_id,String customer_id,String support_team_id) {

        this.creator = this.creatorDao.getCreator(creator_id);

        assertEquals(creator_id, this.creator.getCreatorId());
        assertEquals(customer_id, this.creator.getCustomerId());
        assertEquals(support_team_id, this.creator.getSupportTeamId());

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Creator.csv", numLinesToSkip = 1)
    void getCreators(String creator_id,String customer_id,String support_team_id) {

        List<Creator> ls = this.creatorDao.getCreators("creatorid=3");

        this.creator.setCreatorId(creator_id);
        this.creator.setCustomerId(customer_id);
        this.creator.setSupportTeamId(support_team_id);

        assertEquals(ls.get(0).getCreatorId(),this.creator.getCreatorId());
        assertEquals(ls.get(0).getCustomerId(),this.creator.getCustomerId());
        assertEquals(ls.get(0).getSupportTeamId(),this.creator.getSupportTeamId());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Creator.csv", numLinesToSkip = 1)
    void update(String creator_id,String customer_id,String support_team_id) {

        this.creator.setCreatorId(creator_id);
        this.creator.setCustomerId(customer_id);
        this.creator.setSupportTeamId(support_team_id);

        this.creatorDao.update(this.creator);

        Creator updated = this.creatorDao.getCreator(creator_id);

        assertEquals(this.creator.getCreatorId(),updated.getCreatorId());
        assertEquals(this.creator.getCustomerId(),updated.getCustomerId());
        assertEquals(this.creator.getSupportTeamId(),updated.getSupportTeamId());

    }

}