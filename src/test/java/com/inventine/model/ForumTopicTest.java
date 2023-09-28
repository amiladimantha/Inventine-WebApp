package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumTopicTest {
    ForumTopic forumTopic;

    @BeforeEach
    void setUp() {
        this.forumTopic = new ForumTopic();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/ForumTopic.csv", numLinesToSkip = 1)
    void getterSetter(String forum_topic, String post_id, String title, String views) {

        this.forumTopic.setForumTopicId(forum_topic);
        this.forumTopic.setPostId(post_id);
        this.forumTopic.setTitle(title);
        this.forumTopic.setViews(views);

        assertEquals(forum_topic,this.forumTopic.getForumTopicId());
        assertEquals(post_id,this.forumTopic.getPostId());
        assertEquals(title,this.forumTopic.getTitle());
        assertEquals(views,this.forumTopic.getViews());

    }
}
