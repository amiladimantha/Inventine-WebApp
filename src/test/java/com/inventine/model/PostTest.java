package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    Post post;

    @BeforeEach
    void setUp() {
        this.post = new Post();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Post.csv", numLinesToSkip = 1)
    void getterSetter(String postId, String description, String userId, Timestamp date) {
        this.post.setPostId(postId);
        this.post.setDescription(description);
        this.post.setCreatedAt(date);
        this.post.setUserId(userId);
        assertEquals(postId,this.post.getPostId());
        assertEquals(description,this.post.getDescription());
        assertEquals(date,this.post.getCreatedAt());
        assertEquals(userId,this.post.getUserId());
    }
}