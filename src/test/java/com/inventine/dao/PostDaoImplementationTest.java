package com.inventine.dao;

import com.inventine.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostDaoImplementationTest {
    Post post;
    PostDaoImplementation postDao;

    @BeforeEach
    void setUp() {

        this.post = new Post();
        this.postDao = new PostDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(postDao.getCount("postId=1"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Post.csv", numLinesToSkip = 1)
    void create(String post_id, String description, String user_id , Timestamp createdAt) {



        this.post.setDescription(description);
        this.post.setUserId(user_id);
        int n = this.postDao.create(post);

        assertEquals(6,n);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Post.csv", numLinesToSkip = 1)
    void getPost(String post_id,String description, String user_id) {

        this.post = this.postDao.getPost(post_id);

        assertEquals(post_id,this.post.getPostId());
        assertEquals(description,this.post.getDescription());
        assertEquals(user_id,this.post.getUserId());

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/Post.csv", numLinesToSkip = 1)
    void getPosts(String post_id,String description, String user_id) {

        List<Post> ls = this.postDao.getPosts("postId=1");

        this.post.setPostId(post_id);
        this.post.setDescription(description);
        this.post.setUserId(user_id);

        assertEquals(ls.get(0).getPostId(),this.post.getPostId());
        assertEquals(ls.get(0).getDescription(),this.post.getDescription());
        assertEquals(ls.get(0).getUserId(),this.post.getUserId());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Post.csv", numLinesToSkip = 1)
    void update(String post_id,String description, String user_id) {

        this.post.setPostId(post_id);
        this.post.setDescription(description);
        this.post.setUserId(user_id);

        this.postDao.update(this.post);


        Post updated = this.postDao.getPost(post_id);

        assertEquals(this.post.getPostId(),updated.getPostId());
        assertEquals(this.post.getDescription(),updated.getDescription());
        assertEquals(this.post.getUserId(),updated.getUserId());

    }
}
