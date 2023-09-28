package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.ParticipateDaoInterface;
import com.inventine.model.Participate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipateDaoImplementation implements ParticipateDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from participate";

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
    public boolean create(Participate participate) {

        String query = "INSERT INTO Participate(  projectId,competitionId) " +
                "VALUES ( ?,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(participate.getProjectId()));
            stmt.setInt(2,Integer.parseInt(participate.getCompetitionId()));



            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private Participate setParticipate(Participate participate, ResultSet rs) {

        try {

            participate.setParticipateId(rs.getString("participateId"));
            participate.setCreatedAt(rs.getTimestamp("createdAt"));
            participate.setProjectId(rs.getString("projectId"));
            participate.setCompetitionId(rs.getString("competitionId"));



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return participate;
    }

    @Override
    public Participate getParticipate(String participateId) {

        String query = "SELECT * FROM Participate WHERE participateId= ?";

        Participate participate = new Participate();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(participateId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                participate = setParticipate(participate, rs);
            }

            return participate;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<Participate> getParticipates(String condition) {

        String query = "SELECT * FROM participate";

        List<Participate> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Participate participate = new Participate();
                participate = setParticipate(participate, rs);
                ls.add(participate);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Participate participate) {

        String query = String.format("UPDATE participate SET projectId=?,competitionId=? WHERE participateId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(participate.getProjectId()));
            stmt.setInt(2, Integer.parseInt(participate.getCompetitionId()));
            stmt.setInt(3, Integer.parseInt(participate.getParticipateId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }



}
