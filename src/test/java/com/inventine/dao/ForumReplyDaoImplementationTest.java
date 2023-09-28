package com.inventine.dao;

import com.inventine.model.ForumReply;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForumReplyDaoImplementationTest {
    ForumReply forumReply;
    ForumReplyDaoImplementation forumReplyDao;

    @BeforeEach
    void setUp() {

        this.forumReply = new ForumReply();
        this.forumReplyDao = new ForumReplyDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(forumReplyDao.getCount("forumReplyId=1"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumReply.csv", numLinesToSkip = 1)
    void create(String forum_reply_id,String post_id, String forum_topic_id) {

        this.forumReply.setForumReplyId(forum_reply_id);
        this.forumReply.setForumTopicId(forum_topic_id);
        this.forumReply.setPostId(post_id);


        assertTrue(this.forumReplyDao.create(forumReply));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumReply.csv", numLinesToSkip = 1)
    void getForumReply(String forum_reply_id,String post_id, String forum_topic_id) {


        this.forumReply = this.forumReplyDao.getForumReply(forum_reply_id);

        assertEquals(forum_reply_id,this.forumReply.getForumReplyId());
        assertEquals(post_id,this.forumReply.getPostId());
        assertEquals(forum_topic_id,this.forumReply.getForumTopicId());


    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumReply.csv", numLinesToSkip = 1)
    void getForumReplys(String forum_reply_id,String post_id, String forum_topic_id) {

        List<ForumReply> ls = this.forumReplyDao.getForumReplys("forumReplyId=1");


        this.forumReply.setForumReplyId(forum_reply_id);
        this.forumReply.setPostId(post_id);
        this.forumReply.setForumTopicId(forum_topic_id);

        assertEquals(ls.get(0).getForumReplyId(),this.forumReply.getForumReplyId());
        assertEquals(ls.get(0).getPostId(),this.forumReply.getPostId());
        assertEquals(ls.get(0).getForumTopicId(),this.forumReply.getForumTopicId());



    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumReply.csv", numLinesToSkip = 1)
    void update(String forum_reply_id,String post_id, String forum_topic_id) {

        this.forumReply.setForumReplyId(forum_reply_id);
        this.forumReply.setPostId(post_id);
        this.forumReply.setForumTopicId(forum_topic_id);


        this.forumReplyDao.update(this.forumReply);

        ForumReply updated = this.forumReplyDao.getForumReply(forum_reply_id);

        assertEquals(this.forumReply.getForumReplyId(),updated.getForumReplyId());
        assertEquals(this.forumReply.getPostId(),updated.getPostId());
        assertEquals(this.forumReply.getForumTopicId(),updated.getForumTopicId());


    }
}
