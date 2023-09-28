package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class IssuesTest {

    Issues issues;

    @BeforeEach
    void setUp() {
        this.issues = new Issues();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Issues.csv", numLinesToSkip = 1)
    void getterSetter(String issueId, String userId, String description, char category) {

        this.issues.setIssueId(issueId);
        this.issues.setDescription(description);
        this.issues.setCategory(category);
        this.issues.setUserId(userId);

        assertEquals(issueId,this.issues.getIssueId());
        assertEquals(userId,this.issues.getUserId());
        assertEquals(description,this.issues.getDescription());
        assertEquals(category,this.issues.getCategory());
    }
}