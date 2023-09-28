package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class RateProjectTest {
    RateProject rateProject;

    @BeforeEach
    void setUp() {
        this.rateProject = new RateProject();
    }



    @ParameterizedTest
    @CsvFileSource(resources = "/model/RateProject.csv", numLinesToSkip = 1)
    void getterSetter( String rate_project_id, String project_id, String investor_id, Timestamp created_at, int Project_rating) {

        this.rateProject.setRateProjectId(rate_project_id);
        this.rateProject.setProjectId(project_id);
        this.rateProject.setInvestorId(investor_id);
        this.rateProject.setCreatedAt(created_at);
        this.rateProject.setProjectRating(Project_rating);



        assertEquals(rate_project_id,this.rateProject.getRateProjectId());
        assertEquals(project_id, this.rateProject.getProjectId());
        assertEquals(investor_id, this.rateProject.getInvestorId());
        assertEquals(created_at,this.rateProject.getCreatedAt());
        assertEquals(Project_rating, this.rateProject.getProjectRating());

    }



}