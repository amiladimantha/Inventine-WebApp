package com.inventine.dao;

import com.inventine.model.Post;
import com.inventine.model.PostLike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostLikeDaoImplementationTest {
    PostLike postLike;
    PostLikeDaoImplementation postLikeDao;

    @BeforeEach
    void setUp() {

        this.postLike = new PostLike();
        this.postLikeDao = new PostLikeDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(postLikeDao.getCount("1"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/PostLike.csv", numLinesToSkip = 1)
    void create(String postlikeid,String userId,String postId) {

        this.postLike.setPostLikeId(postlikeid);
        this.postLike.setUserId(userId);
        this.postLike.setPostId(postId);
        assertTrue(this.postLikeDao.create(postLike));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/PostLike.csv", numLinesToSkip = 1)
    void getPostLike(String postlikeId,String userId,String postId,Integer amount) {

        this.postLike = this.postLikeDao.getPostLike(userId,postId);

        assertEquals(postId,this.postLike.getPostId());
        assertEquals(userId,this.postLike.getUserId());

    }



    @ParameterizedTest
    @CsvFileSource(resources = "/model/PostLike.csv", numLinesToSkip = 1)
    void update(String postlikeid,String userId,String postId) {

        this.postLike.setPostLikeId(postlikeid);
        this.postLike.setUserId(userId);
        this.postLike.setPostId(postId);

        this.postLikeDao.update(this.postLike);


        PostLike updated = this.postLikeDao.getPostLike(userId,postId);

        assertEquals(this.postLike.getPostId(),updated.getPostId());
        assertEquals(this.postLike.getPostLikeId(),updated.getPostLikeId());
        assertEquals(this.postLike.getUserId(),updated.getUserId());

    }
}
