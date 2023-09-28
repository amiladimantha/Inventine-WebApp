package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.PostDaoInterface;
import com.inventine.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDaoImplementation implements PostDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from post";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);

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
    public int create(Post post) {

        String query = "INSERT INTO post(description,userId) " +
                "VALUES (?,?) RETURNING postId";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,post.getDescription());
            stmt.setString(2,post.getUserId());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                n = rs.getInt("postId");
            }


            return n;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return -1;

    }

    private Post setPost(Post post, ResultSet rs) {

        try {

            post.setPostId(rs.getString("postId"));
            post.setUserId(rs.getString("userId"));
            post.setDescription(rs.getString("description"));
            post.setCreatedAt(rs.getTimestamp("createDate"));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return post;
    }

    @Override
    public Post getPost(String postId) {

        String query = "SELECT * FROM post WHERE postId= ?";

        Post post = new Post();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(postId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                post = setPost(post,rs);
            }

            return post;

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

    @Override
    public List<Post> getPosts(String condition) {

        String query = "SELECT * FROM post";

        List<Post> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Post post = new Post();
                post = setPost(post,rs);
                ls.add(post);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Post post) {

        String query = String.format("UPDATE post SET userId=?, description=? WHERE postId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(post.getUserId()));
            stmt.setString(2,post.getDescription());
            stmt.setInt(3, Integer.parseInt(post.getPostId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }
}