package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.UniversityDaoInterface;
import com.inventine.model.University;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityDaoImplementation implements UniversityDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from university";

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
    public boolean create(University university) {

        String query = "INSERT INTO University( organizationId, email) " +
                "VALUES (?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(university.getOrganizationId()));
            stmt.setString(2,university.getEmail());



            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private University setUniversity(University university, ResultSet rs) {

        try {

            university.setUniversityId(rs.getString("universityId"));
            university.setOrganizationId(rs.getString("organizationId"));
            university.setEmail(rs.getString("email"));



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return university;
    }

    @Override
    public University getUniversity(String universityId) {

        String query = "SELECT * FROM University WHERE universityId= ?";

        University university = new University();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(universityId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                university = setUniversity(university, rs);
            }

            return university;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<University> getUniversitys(String condition) {

        String query = "SELECT * FROM university";

        List<University> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                University university = new University();
                university = setUniversity(university, rs);
                ls.add(university);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(University university) {

        String query = String.format("UPDATE university SET organizationId=?,email=? WHERE universityId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(university.getOrganizationId()));
            stmt.setString(2, university.getEmail());
            stmt.setInt(3, Integer.parseInt(university.getUniversityId()));


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }



}
