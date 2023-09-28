package com.inventine.dao;

import com.inventine.model.Submit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubmitDaoImplementationTest {

    Submit submit;
    SubmitDaoImplementation submitDao;
    @BeforeEach

    void setUp() {

        this.submit = new Submit();
        this.submitDao = new SubmitDaoImplementation();
    }
    @Test
    void getCount() {
        assertEquals(submitDao.getCount("projectid=1"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Submit.csv", numLinesToSkip = 1)
    void create( String submit_id, Timestamp created_at, String project_id, String competition_id) {

        this.submit.setSubmitId(submit_id);
        this.submit.setCreatedAt(created_at);
        this.submit.setProjectId(project_id);
        this.submit.setCompetitionId(competition_id);


        assertTrue(this.submitDao.create(submit));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Submit.csv", numLinesToSkip = 1)
    void getSubmit(String submit_id, Timestamp created_at, String project_id, String competition_id) {

        this.submit = this.submitDao.getSubmit(submit_id);

        assertEquals(submit_id, this.submit.getSubmitId());
        assertEquals(project_id, this.submit.getProjectId());
        assertEquals(competition_id, this.submit.getCompetitionId());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Submit.csv", numLinesToSkip = 1)
    void getSubmits(String submit_id,  Timestamp created_at,String project_id, String competition_id ) {

        List<Submit> ls = this.submitDao.getSubmits("submitid=19");

        this.submit.setSubmitId(submit_id);
        this.submit.setProjectId(project_id);
        this.submit.setCompetitionId(competition_id);



        assertEquals(ls.get(0).getSubmitId(),this.submit.getSubmitId());
        assertEquals(ls.get(0).getProjectId(),this.submit.getProjectId());
        assertEquals(ls.get(0).getCompetitionId(),this.submit.getCompetitionId());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Submit.csv", numLinesToSkip = 1)
    void update(String submit_id, Timestamp created_at, String project_id, String competition_id ) {

        this.submit.setSubmitId(submit_id);
        this.submit.setProjectId(project_id);
        this.submit.setCompetitionId("43");



        this.submitDao.update(this.submit);

        Submit updated = this.submitDao.getSubmit(submit_id);

        assertEquals(this.submit.getSubmitId(),updated.getSubmitId());
        assertEquals(this.submit.getProjectId(),updated.getProjectId());
        assertEquals("43",updated.getCompetitionId());


    }

}