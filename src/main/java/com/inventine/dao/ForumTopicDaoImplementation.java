package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.ForumTopicDaoInterface;
import com.inventine.model.ForumTopic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForumTopicDaoImplementation implements ForumTopicDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from forumTopic";

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
    public boolean create(ForumTopic forumTopic) {

        String query = "INSERT INTO forumTopic(postId,title) " +
                "VALUES (?,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,forumTopic.getPostId());
            stmt.setString(2,forumTopic.getTitle());


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private ForumTopic setForumTopic(ForumTopic forumTopic, ResultSet rs) {

        try {

            forumTopic.setForumTopicId(rs.getString("forumTopicId"));
            forumTopic.setPostId(rs.getString("postId"));
            forumTopic.setTitle(rs.getString("title"));
            forumTopic.setViews(rs.getString("views"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return forumTopic;
    }

    @Override
    public ForumTopic getForumTopic(String forumTopicId) {

        String query = "SELECT * FROM ForumTopic WHERE forumTopicId= ?";

        ForumTopic forumTopic = new ForumTopic();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(forumTopicId));

            ResultSet rs = stmt.executeQuery();
            System.out.println(rs);

            while (rs.next()) {
                forumTopic = setForumTopic(forumTopic,rs);
            }

            return forumTopic;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<ForumTopic> getForumTopics(String condition,String condition2) {

        if (condition2 == null){
            condition2=" ";
        }

        String query = "SELECT forumtopicid,postid,title,views FROM forumTopic "+condition2+" ORDER BY "+condition+" DESC;";


        List<ForumTopic> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ForumTopic forumTopic= new ForumTopic();
                forumTopic = setForumTopic(forumTopic,rs);
                ls.add(forumTopic);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    public boolean update(ForumTopic forumTopic) {

        String query = String.format("UPDATE forumTopic SET PostId=? , title=? WHERE forumTopicId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(forumTopic.getPostId()));
            stmt.setString(2, forumTopic.getTitle());
            stmt.setInt(3,Integer.parseInt(forumTopic.getForumTopicId()));


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean viewcount(ForumTopic forumTopic) {

        String query = String.format("UPDATE forumTopic SET views=? WHERE forumTopicId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(Integer.toString(Integer.parseInt(forumTopic.getViews())+1)));
            stmt.setInt(2, Integer.parseInt(forumTopic.getForumTopicId()));


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

    @Override
    public String latest_reply(ForumTopic forumTopic) {

        String query = String.format("select postid from forumreply where forumtopicid=? order by postid desc limit 1");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(forumTopic.getForumTopicId()));


            stmt.executeUpdate();

            return null;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }
}