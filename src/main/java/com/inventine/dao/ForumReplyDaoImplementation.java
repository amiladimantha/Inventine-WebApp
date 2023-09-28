package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.ForumReplyDaoInterface;
import com.inventine.model.ForumReply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForumReplyDaoImplementation implements ForumReplyDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from forumreply";

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
    public boolean create(ForumReply forumReply) {

        String query = "INSERT INTO forumReply(forumTopicId,postId) " +
                "VALUES (?,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(forumReply.getForumTopicId()));
            stmt.setInt(2,Integer.parseInt(forumReply.getPostId()));


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private ForumReply setForumReply(ForumReply forumReply, ResultSet rs) {

        try {

            forumReply.setForumReplyId(rs.getString("forumReplyId"));
            forumReply.setForumTopicId(rs.getString("forumTopicId"));
            forumReply.setPostId(rs.getString("postId"));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return forumReply;
    }

    @Override
    public ForumReply getForumReply(String forumReplyId) {

        String query = "SELECT * FROM ForumReply WHERE forumReplyId= ?";

        ForumReply forumReply = new ForumReply();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(forumReplyId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                forumReply = setForumReply(forumReply,rs);
            }

            return forumReply;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

//    @Override
//    public ForumReply getForumReplyPI(String forumTopicId) {
//
//        String query = "SELECT TOP 1 FROM ForumReply WHERE forumTopicId= ? ORDER BY forumreplyid DESC";
//
//        ForumReply forumReply = new ForumReply();
//
//        try {
//
//            PreparedStatement stmt = conn.prepareStatement(query);
//
//            stmt.setInt(1,Integer.parseInt(forumTopicId));
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                forumReply = setForumReply(forumReply,rs);
//            }
//
//            return forumReply;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//
//    }

    @Override
    public List<ForumReply> getForumReplys(String condition) {

        String query = "SELECT * FROM forumreply where forumtopicid=?";

        List<ForumReply> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,Integer.parseInt(condition));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ForumReply forumReply = new ForumReply();
                forumReply = setForumReply(forumReply,rs);
                ls.add(forumReply);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ForumReply getForumReplyLatest(String forumReplyId) {

        String query = "select * from forumreply where forumtopicid=? order by postid desc limit 1";

        ForumReply forumReply = new ForumReply();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(forumReplyId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                forumReply = setForumReply(forumReply,rs);
            }

            return forumReply;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }


    @Override
    public boolean update(ForumReply forumReply) {

        String query = String.format("UPDATE forumReply SET forumTopicId=?, postId=? WHERE forumreplyId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(forumReply.getForumTopicId()));
            stmt.setInt(2, Integer.parseInt(forumReply.getPostId()));
            stmt.setInt(3,Integer.parseInt(forumReply.getForumReplyId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }
}