package com.inventine.model;

import com.inventine.util.DataValidator;

public class PostLike extends User{
    String postLikeId;
    String postId;
    DataValidator validator = new DataValidator();

    public String getPostLikeId() {
        return postLikeId;
    }

    public boolean setPostLikeId(String postLikeId) {
        this.validator.setTxt(postLikeId);
        if(this.validator.isNumber()) {
            this.postLikeId = postLikeId;
            return true;
        }
        return false;
    }

    public String getPostId() {
        return postId;
    }

    public boolean setPostId(String postId) {
        this.validator.setTxt(postId);
        if(this.validator.isNumber()) {
            this.postId = postId;
            return true;
        }
        return false;
    }

}