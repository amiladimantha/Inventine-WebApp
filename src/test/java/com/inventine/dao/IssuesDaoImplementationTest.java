package com.inventine.dao;

import com.inventine.model.Issues;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IssuesDaoImplementationTest {
    Issues issues;
    IssuesDaoImplementation issueDao;

    @BeforeEach
    void setUp() {

        this.issues = new Issues();
        this.issueDao = new IssuesDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(issueDao.getCount("issueId=1"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Issues.csv", numLinesToSkip = 1)
    void create(String issue_id, String user_id,String description, char category) {


        this.issues.setIssueId(issue_id);
        this.issues.setUserId(user_id);
        this.issues.setDescription(description);
        this.issues.setCategory(category);


        assertTrue(this.issueDao.create(issues));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Issues.csv", numLinesToSkip = 1)
    void getIssue(String issue_id, String user_id,String description, char category) {


        this.issues = this.issueDao.getIssue(issue_id);

        assertEquals(issue_id,this.issues.getIssueId());
        assertEquals(user_id,this.issues.getUserId());
        assertEquals(description,this.issues.getDescription());
        assertEquals(category,this.issues.getCategory());


    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Issues.csv", numLinesToSkip = 1)
    void getIssues(String issue_id, String user_id,String description, char category) {

        List<Issues> ls = this.issueDao.getIssues("issueId=1");


        this.issues.setIssueId(issue_id);
        this.issues.setUserId(user_id);
        this.issues.setDescription(description);
        this.issues.setCategory(category);

        assertEquals(ls.get(0).getIssueId(),this.issues.getIssueId());
        assertEquals(ls.get(0).getUserId(),this.issues.getUserId());
        assertEquals(ls.get(0).getDescription(),this.issues.getDescription());
        assertEquals(ls.get(0).getCategory(),this.issues.getCategory());


    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Issues.csv", numLinesToSkip = 1)
    void update(String issue_id, String user_id,String description, char category) {

        this.issues.setIssueId(issue_id);
        this.issues.setUserId(user_id);
        this.issues.setDescription(description);
        this.issues.setCategory(category);

        this.issueDao.update(this.issues);

        Issues updated = this.issueDao.getIssue(issue_id);

        assertEquals(this.issues.getIssueId(),updated.getIssueId());
        assertEquals(this.issues.getUserId(),updated.getUserId());
        assertEquals(this.issues.getDescription(),updated.getDescription());
        assertEquals(this.issues.getCategory(),updated.getCategory());

    }
}
