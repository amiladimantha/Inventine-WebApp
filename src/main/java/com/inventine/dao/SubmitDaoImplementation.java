package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.SubmitDaoInterface;
import com.inventine.model.Submit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubmitDaoImplementation implements SubmitDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from submit";

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
    public boolean create(Submit submit) {

        String query = "INSERT INTO Submit(  projectId,competitionId) " +
                "VALUES ( ?,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(submit.getProjectId()));
            stmt.setInt(2,Integer.parseInt(submit.getCompetitionId()));



            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private Submit setSubmit(Submit submit, ResultSet rs) {

        try {

            submit.setSubmitId(rs.getString("submitId"));
            submit.setCreatedAt(rs.getTimestamp("createdAt"));
            submit.setProjectId(rs.getString("projectId"));
            submit.setCompetitionId(rs.getString("competitionId"));



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return submit;
    }

    @Override
    public Submit getSubmit(String submitId) {

        String query = "SELECT * FROM Submit WHERE submitId= ?";

        Submit submit = new Submit();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(submitId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                submit = setSubmit(submit, rs);
            }

            return submit;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<Submit> getSubmits(String condition) {

        String query = "SELECT * FROM submit";

        List<Submit> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Submit submit = new Submit();
                submit = setSubmit(submit, rs);
                ls.add(submit);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Submit submit) {

        String query = String.format("UPDATE submit SET projectId=?,competitionId=? WHERE submitId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(submit.getProjectId()));
            stmt.setInt(2, Integer.parseInt(submit.getCompetitionId()));
            stmt.setInt(3, Integer.parseInt(submit.getSubmitId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }



}
