package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.ProjectDaoInterface;
import com.inventine.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImplementation implements ProjectDaoInterface {

    static Connection conn = DBManager.getConnection();


    @Override
    public int getCount(String condition)  {

        int count = 0;


        try {
            PreparedStatement stmt = conn.prepareStatement(condition);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            count = rs.getInt("count");
        }catch (SQLException e){
            count = 0;
        }

        return count;
    }

    @Override
    public boolean create(Project project) {

        String query = "INSERT INTO project( creatorId, supportTeamId, financialStatus , status, requestedAmount, dateOfExpiry, projectName , description, category ,imageId) " +
                "VALUES (?, ?, CAST(? AS stat2), CAST(? AS stat1), ?, ?, ?, ?, ? ,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(project.getCreatorId()));
            stmt.setInt(2, Integer.parseInt(project.getSupportTeamId()));
            stmt.setString(3, String.valueOf(project.getFinancialStatus()));
            stmt.setString(4, String.valueOf(project.getStatus()));
            stmt.setInt(5, project.getRequestedAmount());
            stmt.setTimestamp(6, project.getDateOfExpiry());
            stmt.setString(7, project.getProjectName());
            stmt.setString(8, project.getDescription());
            stmt.setString(9, project.getCategory());
            stmt.setString(10, project.getImageId());


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

            return false;

    }

    private Project setProject(Project project, ResultSet rs) {

        try {

            project.setProjectId(rs.getString("projectId"));
            project.setCreatorId(rs.getString("creatorId"));
            project.setSupportTeamId(rs.getString("supportTeamId"));
            project.setCreatedAt(rs.getTimestamp("createdAt"));
            project.setFinancialStatus(rs.getString("financialStatus").charAt(0));
            project.setStatus(rs.getString("status").charAt(0));
            project.setRequestedAmount(rs.getInt("requestedAmount"));
            project.setDateOfExpiry(rs.getTimestamp("dateOfExpiry"));
            project.setProjectName(rs.getString("projectName"));
            project.setDescription(rs.getString("description"));
            project.setCategory(rs.getString("category"));
            project.setImageId(rs.getString("imageId"));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return project;
    }

    @Override
    public Project getProject(String projectId) {

        String query = "SELECT * FROM project WHERE projectId= ? ";

        Project project = new Project();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(projectId));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                project = setProject(project, rs);
            }


            return project;

        } catch (SQLException e) {
            e.printStackTrace();
        }


            return null;

    }

    @Override

    public List<Project> getProjects(String condition) {


        String query = "SELECT * FROM project";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);

            query = query.concat(condition);

        }

        List<Project> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Project project = new Project();
                project = setProject(project, rs);
                ls.add(project);
            }


            return ls;


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override
    public boolean update(Project project) {

        String query = String.format("UPDATE project SET supportTeamId=?,  financialStatus=CAST(? AS stat2), status=CAST(? AS stat1), requestedAmount=?, dateOfExpiry=? , projectName=?, description=?, category=?, imageId=? WHERE projectId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(project.getSupportTeamId()));
            stmt.setString(2, String.valueOf(project.getFinancialStatus()));
            stmt.setString(3, String.valueOf(project.getStatus()));
            stmt.setInt(4, project.getRequestedAmount());
            stmt.setTimestamp(5, project.getDateOfExpiry());
            stmt.setString(6,project.getProjectName());
            stmt.setString(7,project.getDescription());
            stmt.setString(8,project.getCategory());
            stmt.setString(9, project.getImageId());
            stmt.setInt(10, Integer.parseInt(project.getProjectId()));




            stmt.executeUpdate();

            return  true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }



}