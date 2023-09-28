package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class ForumTopic extends Post{
    private String forumTopicId;
    private String postId;
    private String title;
    private Integer likeAmount;
    private Integer replyAmount;
    private String views;
    private Timestamp latest_reply;
    private String image;
    private DataValidator validator = new DataValidator();

    public String getForumTopicId() {
        return forumTopicId;
    }

    public boolean setForumTopicId(String forumTopicId) {
        this.validator.setTxt(forumTopicId);
        if(this.validator.isNumber()){
            this.forumTopicId = forumTopicId;
            return true;
        }
        return false;
    }


    public String getPostId() {
        return postId;
    }

    public boolean setPostId(String postId) {
        this.validator.setTxt(postId);
        if(this.validator.isNumber()){
            this.postId = postId;
            return true;
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public boolean setTitle(String title) {
        this.validator.setTxt(title);
        this.validator.setMaxLength(150);
        this.title = title;
        return true;
    }

    public Integer getLikeAmount() {
        return likeAmount;
    }

    public void setLikeAmount(Integer likeAmount) {
        this.likeAmount = likeAmount;
    }

    public Integer getReplyAmount() {
        return replyAmount;
    }

    public void setReplyAmount(Integer replyAmount) {
        this.replyAmount = replyAmount;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
            this.views = views;
    }

    public Timestamp getLatest_reply() {
        return latest_reply;
    }

    public void setLatest_reply(Timestamp latest_reply) {
        this.latest_reply = latest_reply;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}