package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.IssuesDaoInterface;
import com.inventine.model.Issues;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IssuesDaoImplementation implements IssuesDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from Issues";

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
    public boolean create(Issues issues) {

        String query = "INSERT INTO Issues(userId,Category,description,status) " +
                "VALUES (?,cast(? AS stat3) ,?,cast(? AS stati))";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(issues.getUserId()));
            stmt.setString(2,String.valueOf(issues.getCategory()));
            stmt.setString(3,issues.getDescription());
            stmt.setString(4, String.valueOf(issues.getStatus()));


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private Issues setIssue(Issues issues, ResultSet rs) {

        try {


            issues.setIssueId((rs.getString("IssueId")));
            issues.setUserId(rs.getString("userId"));
            issues.setCategory(rs.getString("category").charAt(0));
            issues.setDescription(rs.getString("description"));



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issues;
    }

    @Override
    public Issues getIssue(String issueId) {

        String query = "SELECT * FROM issues WHERE issueId= ?";

        Issues issues = new Issues();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(issueId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                issues = setIssue(issues,rs);
            }

            return issues;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public Issues getIssueCount(String query) {



        Issues issues = new Issues();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                issues = setIssuecount(issues,rs);
            }

            return issues;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    private Issues setIssuecount(Issues issues, ResultSet rs) {

        try {


            issues.setCount(rs.getString("count"));



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return issues;
    }

    @Override
    public List<Issues> getIssues(String condition) {

        String query = "SELECT * FROM issues";

        List<Issues> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Issues issues = new Issues();
                issues = setIssue(issues,rs);
                ls.add(issues);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Issues issues) {

        String query = String.format("UPDATE issues SET userId=?, category=CAST(? AS stat3), description=? WHERE issueId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(issues.getIssueId()));
            stmt.setString(2,String.valueOf(issues.getCategory()));
            stmt.setString(3,issues.getDescription());
            stmt.setInt(4,Integer.parseInt(issues.getIssueId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

}