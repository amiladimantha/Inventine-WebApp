package com.inventine.dao.interface_;

import com.inventine.model.Post;
import com.inventine.model.PostLike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PostLikeDaoInterface {
    public boolean create(PostLike postLike);

    public PostLike getPostLike(String userId,String postId);

//    public Post getPostPI(String postId);

//    public List<Post> getPosts(String condition);

    public boolean delete(PostLike postLike);

    public boolean update(PostLike postLike);

    public int getCount(String condition) throws SQLException;

    public ResultSet executeQuery(String query);


}