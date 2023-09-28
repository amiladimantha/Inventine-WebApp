package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.RateProjectDaoInterface;
import com.inventine.model.RateCreator;
import com.inventine.model.RateProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RateProjectDaoImplementation implements RateProjectDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from rateProject";

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
    public boolean create(RateProject rateProject) {

        String query = "INSERT INTO RateProject( projectId, investorId, projectRating) " +
                "VALUES (?, ?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(rateProject.getProjectId()));
            stmt.setInt(2, Integer.parseInt(rateProject.getInvestorId()));
            stmt.setInt(3, rateProject.getProjectRating());


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;


    }

    private RateProject setRateProject(RateProject rateProject, ResultSet rs) {

        try {

            rateProject.setRateProjectId(rs.getString("rateProjectId"));
            rateProject.setProjectId(rs.getString("projectId"));
            rateProject.setInvestorId(rs.getString("investorId"));
            rateProject.setProjectRating(rs.getInt("projectRating"));
            rateProject.setCreatedAt(rs.getTimestamp("createdAt"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rateProject;
    }

    @Override
    public RateProject getRateProject(String rateProjectId) {

        String query = "SELECT * FROM rateProject WHERE rateProjectId= ?";

        RateProject rateProject = new RateProject();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(rateProjectId));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                rateProject = setRateProject(rateProject, rs);
            }


            return rateProject;


        } catch (SQLException e) {
            e.printStackTrace();
        }

            return null;

    }

    @Override

    public List<RateProject> getRateProjects(String condition) {


        String query = "SELECT * FROM rateProject";

        List<RateProject> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RateProject rateProject = new RateProject();
                rateProject = setRateProject(rateProject, rs);
                ls.add(rateProject);
            }


            return ls;


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override
    public boolean update(RateProject rateProject) {

        String query = String.format("UPDATE rateProject SET projectId=?, investorId=?, projectRating=? WHERE rateProjectId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(rateProject.getProjectId()));
            stmt.setInt(2, Integer.parseInt(rateProject.getInvestorId()));
            stmt.setInt(3, rateProject.getProjectRating());
            stmt.setInt(4, Integer.parseInt(rateProject.getRateProjectId()));


            stmt.executeUpdate();

            return  true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

}