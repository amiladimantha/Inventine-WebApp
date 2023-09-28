package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.MeetingDaoInterface;
import com.inventine.model.Meeting;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingDaoImplementation implements MeetingDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from meeting";

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
    public boolean create(Meeting meeting) {

        String query = "INSERT INTO meeting(creatorId, launchedAt, link, description,status)"+
                "VALUES (?, ?, ?, ?, CAST(? AS statm))";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.valueOf(meeting.getCreatorId()));
            stmt.setTimestamp(2, meeting.getLaunchedAt());
            stmt.setString(3, meeting.getLink());
            stmt.setString(4, meeting.getDescription());
            stmt.setString(5, String.valueOf(meeting.getStatus()));

            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    private Meeting setMeeting(Meeting meeting, ResultSet rs) {

        try {

            meeting.setMeetingId(rs.getString("meetingId"));
            meeting.setCreatorId(rs.getString("creatorId"));
            meeting.setLaunchedAt(rs.getTimestamp("launchedAt"));
            meeting.setLink(rs.getString("link"));
            meeting.setDescription(rs.getString("description"));
            meeting.setStatus(rs.getString("status").charAt(0));
            meeting.setCreatedAt(rs.getTimestamp("createdAt"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meeting;
    }

    @Override
    public Meeting getMeeting(String meetingId) {

        String query = "SELECT * FROM meeting WHERE meetingId= ?";

        Meeting meeting = new Meeting();


        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(meetingId));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                meeting = setMeeting(meeting, rs);
            }


            return meeting;

        } catch (SQLException e) {
            e.printStackTrace();
        }


            return null;

    }

    @Override

    public List<Meeting> getMeetings(String condition) {


        String query = "SELECT * FROM meeting";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);

            query = query.concat(condition);

        }

        List<Meeting> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Meeting meeting = new Meeting();
                meeting = setMeeting(meeting, rs);
                ls.add(meeting);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override
    public boolean update(Meeting meeting) {

        String query = String.format("UPDATE Meeting SET creatorId=?, launchedAt=?, link=?, description=?, status=? WHERE meetingId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(meeting.getCreatorId()));
            stmt.setTimestamp(2, meeting.getLaunchedAt());
            stmt.setString(3, meeting.getLink());
            stmt.setString(4, meeting.getDescription());
            stmt.setString(5, String.valueOf(meeting.getStatus()));
            stmt.setInt(6, Integer.parseInt(meeting.getMeetingId()));



            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }



}