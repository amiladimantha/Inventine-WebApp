package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.AcceptMeetingDaoInterface;
import com.inventine.model.AcceptMeeting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcceptMeetingDaoImplementation implements AcceptMeetingDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from acceptMeeting";

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

//    @Override
//    public  int getCountAmount(String condition){
//        int count = 0;
//        String query = "select sum(amount) from payment";
//
//        if (!condition.isEmpty()){
//
//            condition = String.format(" WHERE %s",condition);
//            query = query.concat(condition);
//
//        }
//
//        try {
//            PreparedStatement stmt = conn.prepareStatement(query);
//            ResultSet rs = stmt.executeQuery();
//            rs.next();
//            count = rs.getInt("sum");
//        }catch (SQLException e){
//            count = 0;
//        }
//
//        return count;
//    }
//
//    @Override
//    public ResultSet executeQuery(String query)  {
//        ResultSet rs = null;
//
//        try {
//            PreparedStatement stmt = conn.prepareStatement(query);
//            rs = stmt.executeQuery();
//            rs.next();
//
//        }catch (SQLException e){
//
//
//            e.printStackTrace();
//        }
//
//        return rs;
//    }

    @Override
    public boolean create(AcceptMeeting acceptMeeting) {

        String query = "INSERT INTO AcceptMeeting( investorId, meetingId) " +
                "VALUES (?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(acceptMeeting.getInvestorId()));
            stmt.setInt(2, Integer.parseInt(acceptMeeting.getMeetingId()));



            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;

    }

    private AcceptMeeting setAcceptMeeting(AcceptMeeting acceptMeeting, ResultSet rs) {

        try {

            acceptMeeting.setAcceptMeetingId(rs.getString("acceptMeetingId"));
            acceptMeeting.setInvestorId(rs.getString("investorId"));
            acceptMeeting.setMeetingId(rs.getString("meetingId"));
            acceptMeeting.setCreatedAt(rs.getTimestamp("createdAt"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return acceptMeeting;
    }

    @Override
    public AcceptMeeting getAcceptMeeting(String acceptMeetingId) {

        String query = "SELECT * FROM acceptMeeting WHERE acceptMeetingId= ?";

        AcceptMeeting acceptMeeting = new AcceptMeeting();


        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(acceptMeetingId));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                acceptMeeting = setAcceptMeeting(acceptMeeting, rs);
            }

            return acceptMeeting;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override

    public List<AcceptMeeting> getAcceptMeetings(String condition) {


        String query = "SELECT * FROM acceptMeeting";

        List<AcceptMeeting> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AcceptMeeting acceptMeeting = new AcceptMeeting();
                acceptMeeting = setAcceptMeeting(acceptMeeting, rs);
                ls.add(acceptMeeting);
            }

            return ls;


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override
    public boolean update(AcceptMeeting acceptMeeting) {

        String query = String.format("UPDATE acceptMeeting SET investorId=?, meetingId=? WHERE acceptMeetingId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(acceptMeeting.getInvestorId()));
            stmt.setInt(2, Integer.parseInt(acceptMeeting.getMeetingId()));
            stmt.setInt(3, Integer.parseInt(acceptMeeting.getAcceptMeetingId()));


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}