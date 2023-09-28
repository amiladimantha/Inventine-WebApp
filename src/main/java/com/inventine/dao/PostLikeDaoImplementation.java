package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.PostDaoInterface;
import com.inventine.dao.interface_.PostLikeDaoInterface;
import com.inventine.model.Post;
import com.inventine.model.PostLike;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostLikeDaoImplementation implements PostLikeDaoInterface {
    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from postlike ";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE postid=%s;",condition);

            query = query.concat(condition);

        }


        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            count = rs.getInt("count");
        }catch (SQLException e){
            count = 0;
        }

        return count;
    }

    @Override
    public ResultSet executeQuery(String query)  {
        ResultSet rs = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            rs.next();

        }catch (SQLException e){


            e.printStackTrace();
        }

        return rs;
    }


    @Override
    public boolean create(PostLike postlike) {

        String query = "INSERT INTO postlike(userId,postId) " +
                "VALUES (?,?) RETURNING postLikeId";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(postlike.getUserId()));
            stmt.setInt(2,Integer.parseInt(postlike.getPostId()));


            ResultSet rs = stmt.executeQuery();


            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private PostLike setPostLike(PostLike postLike, ResultSet rs) {

        try {
            postLike.setPostLikeId(rs.getString("postLikeId"));
            postLike.setPostId(rs.getString("postId"));
            postLike.setUserId(rs.getString("userId"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return postLike;
    }

    @Override
    public PostLike getPostLike(String userId,String postId) {

        String query = "SELECT * FROM postLike WHERE userId= ? and postId=?";

        PostLike postLike = new PostLike();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(userId));
            stmt.setInt(2,Integer.parseInt(postId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                postLike = setPostLike(postLike,rs);
            }

            return postLike;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

//    @Override
//    public Post getPostPI(String postId) {
//
//        String query = "SELECT * FROM post WHERE forumreplyId= ?";
//
//        Post post = new Post();
//
//        try {
//
//            PreparedStatement stmt = conn.prepareStatement(query);
//
//            stmt.setInt(1,Integer.parseInt(postId));
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                post = setPost(post,rs);
//            }
//
//            return post;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//
//    }

//    @Override
//    public List<Post> getPosts(String condition) {
//
//        String query = "SELECT * FROM post";
//
//        List<Post> ls = new ArrayList();
//
//        try {
//
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                Post post = new Post();
//                post = setPost(post,rs);
//                ls.add(post);
//            }
//
//            return ls;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

    @Override
    public boolean update(PostLike postLike) {

        String query = String.format("UPDATE postLike SET userId=?, postId=? WHERE postlikeId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(postLike.getUserId()));
            stmt.setInt(2, Integer.parseInt(postLike.getPostId()));
            stmt.setInt(3,Integer.parseInt(postLike.getPostLikeId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean delete(PostLike postLike) {

        String query = String.format("delete from postLike WHERE userId =? AND postId");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(postLike.getUserId()));
            stmt.setInt(2,Integer.parseInt(postLike.getPostId()));


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }
}