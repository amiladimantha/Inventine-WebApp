package com.inventine.model;


import com.inventine.util.DataValidator;

public class ForumReply extends Post{
    private String forumReplyId;
    private String postId;
    private String forumTopicId;
    private Integer amount;
    private String image;
    private DataValidator validator = new DataValidator();

    public String getForumReplyId() {
        return forumReplyId;
    }

    public boolean setForumReplyId(String forumReplyId) {
        this.validator.setTxt(forumReplyId);
        if(this.validator.isNumber()){
            this.forumReplyId = forumReplyId;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}