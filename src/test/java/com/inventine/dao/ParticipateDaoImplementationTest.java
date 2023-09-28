package com.inventine.dao;

import com.inventine.model.Participate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParticipateDaoImplementationTest {

    Participate participate;
    ParticipateDaoImplementation participateDao;
    @BeforeEach

    void setUp() {

        this.participate = new Participate();
        this.participateDao = new ParticipateDaoImplementation();
    }
    @Test
    void getCount() {
        assertEquals(participateDao.getCount("projectId=5"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Participate.csv", numLinesToSkip = 1)
    void create( String participate_id, Timestamp created_at, String project_id, String competition_id) {

        this.participate.setParticipateId(participate_id);
       // this.participate.setCreatedAt(created_at);
        this.participate.setProjectId(project_id);
        this.participate.setCompetitionId(competition_id);


        assertTrue(this.participateDao.create(participate));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Participate.csv", numLinesToSkip = 1)
    void getParticipate(String participate_id, Timestamp created_at, String project_id, String competition_id) {

        this.participate = this.participateDao.getParticipate(participate_id);

        assertEquals(participate_id, this.participate.getParticipateId());
        assertEquals(project_id, this.participate.getProjectId());
        assertEquals(competition_id, this.participate.getCompetitionId());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Participate.csv", numLinesToSkip = 1)
    void getParticipates(String participate_id,  Timestamp created_at,String project_Id, String competition_id ) {

        List<Participate> ls = this.participateDao.getParticipates("participate=20");

        this.participate.setParticipateId(participate_id);
        this.participate.setProjectId(project_Id);
        this.participate.setCompetitionId(competition_id);



        assertEquals(ls.get(0).getParticipateId(),this.participate.getParticipateId());
        assertEquals(ls.get(0).getProjectId(),this.participate.getProjectId());
        assertEquals(ls.get(0).getCompetitionId(),this.participate.getCompetitionId());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Participate.csv", numLinesToSkip = 1)
    void update(String participate_id, Timestamp created_at, String project_Id, String competition_id ) {

        this.participate.setParticipateId(participate_id);
        this.participate.setProjectId(project_Id);
        this.participate.setCompetitionId("43");



        this.participateDao.update(this.participate);

        Participate updated = this.participateDao.getParticipate(participate_id);

        assertEquals(this.participate.getParticipateId(),updated.getParticipateId());
        assertEquals(this.participate.getProjectId(),updated.getProjectId());
        assertEquals("43",updated.getCompetitionId());


    }

}