package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectTest {
    Project project;

    @BeforeEach
    void setUp() {
        this.project = new Project();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Project.csv", numLinesToSkip = 1)
    void getterSetter(String project_id, String creator_id, String support_team_id, Timestamp created_at, char financial_status, char status, int requested_amount, Timestamp date_of_expiry, String project_name, String description, String category) {

        this.project.setProjectId(project_id);
        this.project.setCreatorId(creator_id);
        this.project.setSupportTeamId(support_team_id);
        this.project.setCreatedAt(created_at);
        this.project.setFinancialStatus(financial_status);
        this.project.setStatus(status);
        this.project.setRequestedAmount(requested_amount);
        this.project.setDateOfExpiry(date_of_expiry);
        this.project.setProjectName(project_name);
//        this.project.setDescription(description);
        this.project.setCategory(category);

        assertEquals(project_id, this.project.getProjectId());
        assertEquals(creator_id, this.project.getCreatorId());
        assertEquals(support_team_id, this.project.getSupportTeamId());
        assertEquals(created_at, this.project.getCreatedAt());
        assertEquals(financial_status, this.project.getFinancialStatus());
        assertEquals(status, this.project.getStatus());
        assertEquals(requested_amount, this.project.getRequestedAmount());
        assertEquals(date_of_expiry, this.project.getDateOfExpiry());
        assertEquals(project_name, this.project.getProjectName());
//        assertEquals(description, this.project.getDescription());
        assertEquals(category, this.project.getCategory());
    }
}
