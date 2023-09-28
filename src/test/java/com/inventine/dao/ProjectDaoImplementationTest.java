package com.inventine.dao;

import com.inventine.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectDaoImplementationTest {

    Project project;
    ProjectDaoImplementation projectDao;
    @BeforeEach

    void setUp() {

        this.project = new Project();
        this.projectDao = new ProjectDaoImplementation();
    }
    @Test
    void getCount() {
       assertEquals(projectDao.getCount("creatorid=5 AND status='A'"),2);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Project.csv", numLinesToSkip = 1)
    void create( String project_id, String creator_id, String support_team_id, Timestamp created_at, char financial_status, char status, int requested_amount, Timestamp date_of_expiry, String project_name, String description, String category) {

        this.project.setProjectId(project_id);
        this.project.setCreatorId(creator_id);
        this.project.setSupportTeamId(support_team_id);
        this.project.setFinancialStatus(financial_status);
        this.project.setStatus(status);
        this.project.setRequestedAmount(requested_amount);
        this.project.setDateOfExpiry(date_of_expiry);
        this.project.setCreatedAt(created_at);
        this.project.setProjectName(project_name);
        this.project.setDescription(description);
        this.project.setCategory(category);

        assertTrue(this.projectDao.create(project));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Project.csv", numLinesToSkip = 1)
    void getProject(String project_id, String creator_id, String support_team_id, Timestamp created_at, char financial_status, char status, int requested_amount, Timestamp date_of_expiry, String project_name, String description, String category) {

        this.project = this.projectDao.getProject(project_id);

        assertEquals(project_id, this.project.getProjectId());
        assertEquals(creator_id, this.project.getCreatorId());
        assertEquals(support_team_id, this.project.getSupportTeamId());
        assertEquals(financial_status, this.project.getFinancialStatus());
        assertEquals(status, this.project.getStatus());
        assertEquals(requested_amount, this.project.getRequestedAmount());
        assertEquals(date_of_expiry, this.project.getDateOfExpiry());
        assertEquals(project_name, this.project.getProjectName());
        assertEquals(description, this.project.getDescription());
        assertEquals(category, this.project.getCategory());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Project.csv", numLinesToSkip = 1)
    void getProjects(String project_id, String creator_id, String support_team_id, Timestamp created_at, char financial_status, char status, int requested_amount, Timestamp date_of_expiry, String project_name, String description, String category) {

        List<Project> ls = this.projectDao.getProjects("creatorid=5");

        this.project.setProjectId(project_id);
        this.project.setCreatorId(creator_id);
        this.project.setSupportTeamId(support_team_id);
        this.project.setFinancialStatus(financial_status);
        this.project.setStatus(status);
        this.project.setRequestedAmount(requested_amount);
        this.project.setDateOfExpiry(date_of_expiry);
        this.project.setProjectName(project_name);
        this.project.setDescription(description);
        this.project.setCategory(category);


        assertEquals(ls.get(0).getProjectId(),this.project.getProjectId());
        assertEquals(ls.get(0).getCreatorId(),this.project.getCreatorId());
        assertEquals(ls.get(0).getSupportTeamId(),this.project.getSupportTeamId());
        assertEquals(ls.get(0).getFinancialStatus(),this.project.getFinancialStatus());
        assertEquals(ls.get(0).getStatus(),this.project.getStatus());
        assertEquals(ls.get(0).getRequestedAmount(),this.project.getRequestedAmount());
        assertEquals(ls.get(0).getDateOfExpiry(),this.project.getDateOfExpiry());
        assertEquals(ls.get(0).getProjectName(),this.project.getProjectName());
        assertEquals(ls.get(0).getDescription(),this.project.getDescription());
        assertEquals(ls.get(0).getCategory(),this.project.getCategory());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Project.csv", numLinesToSkip = 1)
    void update(String project_id, String creator_id, String support_team_id, Timestamp created_at, char financial_status, char status, int requested_amount, Timestamp date_of_expiry, String project_name, String description, String category) {

        this.project.setProjectId(project_id);
        this.project.setCreatorId(creator_id);
        this.project.setSupportTeamId(support_team_id);
        this.project.setFinancialStatus(financial_status);
        this.project.setStatus(status);
        this.project.setRequestedAmount(requested_amount);
        this.project.setDateOfExpiry(date_of_expiry);
        this.project.setProjectName(project_name);
        this.project.setDescription(description);
        this.project.setCategory(category);


        this.projectDao.update(this.project);

        Project updated = this.projectDao.getProject(project_id);

        assertEquals(this.project.getProjectId(),updated.getProjectId());
        assertEquals(this.project.getCreatorId(),updated.getCreatorId());
        assertEquals(this.project.getSupportTeamId(),updated.getSupportTeamId());
        assertEquals(this.project.getFinancialStatus(),updated.getFinancialStatus());
        assertEquals(this.project.getStatus(),updated.getStatus());
        assertEquals(this.project.getRequestedAmount(),updated.getRequestedAmount());
        assertEquals(this.project.getDateOfExpiry(),updated.getDateOfExpiry());
        assertEquals(this.project.getProjectName(),updated.getProjectName());
        assertEquals(this.project.getDescription(),updated.getDescription());
        assertEquals(this.project.getCategory(),updated.getCategory());

    }

}