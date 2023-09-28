package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class SubmitTest {

    Submit submit;

    @BeforeEach
    void setUp() {
        this.submit =new Submit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Submit.csv", numLinesToSkip = 1)
    void getterSetter(String submit_Id, Timestamp created_Id,String project_Id,String competition_Id) {

        this.submit.setSubmitId(submit_Id);
        this.submit.setCreatedAt(created_Id);
        this.submit.setProjectId(project_Id);
        this.submit.setCompetitionId(competition_Id);

        assertEquals(submit_Id,this.submit.getSubmitId());
        assertEquals(created_Id,this.submit.getCreatedAt());
        assertEquals(project_Id,this.submit.getProjectId());
        assertEquals(competition_Id,this.submit.getCompetitionId());

    }

}