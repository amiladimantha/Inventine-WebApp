package com.inventine.dao;

import com.inventine.model.ForumTopic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ForumTopicDaoImplementationTest {

    ForumTopic forumTopic;
    ForumTopicDaoImplementation forumTopicDao;

    @BeforeEach
    void setUp() {

        this.forumTopic = new ForumTopic();
        this.forumTopicDao = new ForumTopicDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(forumTopicDao.getCount("forumTopicId=1"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumTopic.csv", numLinesToSkip = 1)
    void create(String forum_topic_id,String post_id, String title) {


        this.forumTopic.setForumTopicId(forum_topic_id);
        this.forumTopic.setPostId(post_id);
        this.forumTopic.setTitle(title);



        assertTrue(this.forumTopicDao.create(forumTopic));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumTopic.csv", numLinesToSkip = 1)
    void getForumTopic(String forum_topic_id,String post_id, String title, String views) {


        this.forumTopic = this.forumTopicDao.getForumTopic(forum_topic_id);

        assertEquals(forum_topic_id,this.forumTopic.getForumTopicId());
        assertEquals(post_id,this.forumTopic.getPostId());
        assertEquals(title,this.forumTopic.getTitle());
        assertEquals(views,this.forumTopic.getViews());


    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumTopic.csv", numLinesToSkip = 1)
    void getForumTopics(String forum_topic_id ,String post_id, String title) {

        List<ForumTopic> ls = this.forumTopicDao.getForumTopics("forumTopicId=1","");


        this.forumTopic.setForumTopicId(forum_topic_id);
        this.forumTopic.setPostId(post_id);
        this.forumTopic.setTitle(title);

        assertEquals(ls.get(0).getForumTopicId(),this.forumTopic.getForumTopicId());
        assertEquals(ls.get(0).getPostId(),this.forumTopic.getPostId());
        assertEquals(ls.get(0).getTitle(),this.forumTopic.getTitle());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumTopic.csv", numLinesToSkip = 1)
    void update(String forum_topic_id,String post_id, String title) {

        this.forumTopic.setForumTopicId(forum_topic_id);
        this.forumTopic.setPostId(post_id);
        this.forumTopic.setTitle(title);

        this.forumTopicDao.update(this.forumTopic);

        ForumTopic updated = this.forumTopicDao.getForumTopic(forum_topic_id);

        assertEquals(this.forumTopic.getForumTopicId(),updated.getForumTopicId());
        assertEquals(this.forumTopic.getPostId(),updated.getPostId());
        assertEquals(this.forumTopic.getTitle(),updated.getTitle());

    }
}
