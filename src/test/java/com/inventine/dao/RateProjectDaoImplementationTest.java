package com.inventine.dao;

import com.inventine.model.RateProject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RateProjectDaoImplementationTest {

    RateProject rateProject;
    RateProjectDaoImplementation rateProjectDao;
    @BeforeEach
    void setUp() {

        this.rateProject = new RateProject();
        this.rateProjectDao = new RateProjectDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(rateProjectDao.getCount("projectid=1"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/RateProject.csv", numLinesToSkip = 1)
    void create( String rate_project_id, String project_id, String investor_id, Timestamp created_at, int project_rating) {

        this.rateProject.setRateProjectId(rate_project_id);
        this.rateProject.setProjectId(project_id);
        this.rateProject.setInvestorId(investor_id);
        this.rateProject.setProjectRating(project_rating);
        this.rateProject.setCreatedAt(created_at);

        assertTrue(this.rateProjectDao.create(rateProject));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/RateProject.csv", numLinesToSkip = 1)
    void getRateProject(String rate_project_id, String project_id, String investor_id, Timestamp created_at, int project_rating) {

        this.rateProject = this.rateProjectDao.getRateProject(rate_project_id);

        assertEquals(rate_project_id, this.rateProject.getRateProjectId());
        assertEquals(project_id, this.rateProject.getProjectId());
        assertEquals(investor_id, this.rateProject.getInvestorId());
        assertEquals(project_rating, this.rateProject.getProjectRating());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/RateProject.csv", numLinesToSkip = 1)
    void getRateProjects(String rate_project_id, String project_id, String investor_id, Timestamp created_at, int project_rating) {

        List<RateProject> ls = this.rateProjectDao.getRateProjects("projectid=1");

        this.rateProject.setRateProjectId(rate_project_id);
        this.rateProject.setProjectId(project_id);
        this.rateProject.setInvestorId(investor_id);
        this.rateProject.setProjectRating(project_rating);

        assertEquals(ls.get(0).getRateProjectId(),this.rateProject.getRateProjectId());
        assertEquals(ls.get(0).getProjectId(),this.rateProject.getProjectId());
        assertEquals(ls.get(0).getInvestorId(),this.rateProject.getInvestorId());
        assertEquals(ls.get(0).getProjectRating(),this.rateProject.getProjectRating());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/RateProject.csv", numLinesToSkip = 1)
    void update(String rate_project_id, String project_id, String investor_id, Timestamp created_at, int project_rating) {

        this.rateProject.setRateProjectId(rate_project_id);
        this.rateProject.setProjectId(project_id);
        this.rateProject.setInvestorId(investor_id);
        this.rateProject.setProjectRating(project_rating);


        this.rateProjectDao.update(this.rateProject);

        RateProject updated = this.rateProjectDao.getRateProject(rate_project_id);

        assertEquals(this.rateProject.getRateProjectId(),updated.getRateProjectId());
        assertEquals(this.rateProject.getProjectId(),updated.getProjectId());
        assertEquals(this.rateProject.getInvestorId(),updated.getInvestorId());
        assertEquals(this.rateProject.getProjectRating(),updated.getProjectRating());

    }

}