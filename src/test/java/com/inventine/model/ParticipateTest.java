package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class ParticipateTest {

    Participate participate;

    @BeforeEach
    void setUp() {
        this.participate = new Participate();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Participate.csv", numLinesToSkip = 1)
    void getterSetter(String participate_Id, Timestamp created_At, String competition_Id, String project_Id) {

        this.participate.setParticipateId(participate_Id);
        this.participate.setCreatedAt(created_At);
        this.participate.setCompetitionId(competition_Id);
        this.participate.setProjectId(project_Id);

        assertEquals(participate_Id, this.participate.getParticipateId());
        assertEquals(created_At, this.participate.getCreatedAt());
        assertEquals(competition_Id, this.participate.getCompetitionId());
        assertEquals(project_Id, this.participate.getProjectId());


    }
}