package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostLikeTest {
    PostLike postLike;

    @BeforeEach
    void setUp() {
        this.postLike = new PostLike();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/PostLike.csv", numLinesToSkip = 1)
    void getterSetter(String postLkeId, String postId) {
        this.postLike.setPostLikeId(postLkeId);
        this.postLike.setPostId(postId);
        assertEquals(postId,this.postLike.getPostId());
        assertEquals(postLkeId,this.postLike.getPostLikeId());
    }
}
