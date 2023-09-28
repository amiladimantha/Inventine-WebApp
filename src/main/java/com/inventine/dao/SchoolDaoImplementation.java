package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.SchoolDaoInterface;
import com.inventine.model.School;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolDaoImplementation implements SchoolDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from school";

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
    public boolean create(School school) {

        String query = "INSERT INTO School( organizationId) " +
                "VALUES (?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(school.getOrganizationId()));




            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private School setSchool(School school, ResultSet rs) {

        try {

            school.setSchoolId(rs.getString("schoolId"));
            school.setOrganizationId(rs.getString("organizationId"));




        } catch (SQLException e) {
            e.printStackTrace();
        }

        return school;
    }

    @Override
    public School getSchool(String schoolId) {

        String query = "SELECT * FROM School WHERE schoolId= ?";

        School school = new School();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(schoolId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                school = setSchool(school, rs);
            }

            return school;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<School> getSchools(String condition) {

        String query = "SELECT * FROM school";

        List<School> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                School school = new School();
                school = setSchool(school, rs);
                ls.add(school);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(School school) {

        String query = String.format("UPDATE school SET organizationId=? WHERE schoolId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(school.getOrganizationId()));

            stmt.setInt(2, Integer.parseInt(school.getSchoolId()));


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }



}
