package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.CreatorDaoInterface;
import com.inventine.model.Creator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreatorDaoImplementation implements CreatorDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from creator";

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
    public boolean create(Creator creator) {

        String query = "INSERT INTO Creator( customerId, supportTeamId) " +
                "VALUES (?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(creator.getCustomerId()));
            stmt.setInt(2, Integer.parseInt(creator.getSupportTeamId()));


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

            return false;

    }

    private Creator setCreator(Creator creator, ResultSet rs) {

        try {

            creator.setCreatorId(rs.getString("creatorId"));
            creator.setCustomerId(rs.getString("customerId"));
            creator.setSupportTeamId(rs.getString("supportTeamId"));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return creator;
    }

    @Override
    public Creator getCreator(String creatorId) {

        String query = "SELECT * FROM Creator WHERE creatorId= ?";

        Creator creator = new Creator();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(creatorId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                creator = setCreator(creator, rs);
            }

            return creator;

        } catch (SQLException e) {
            e.printStackTrace();
        }

            return null;

    }

    @Override
    public List<Creator> getCreators(String condition) {

        String query = "SELECT * FROM creator";

        List<Creator> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Creator creator = new Creator();
                creator = setCreator(creator, rs);
                ls.add(creator);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Creator creator) {

        String query = String.format("UPDATE creator SET customerId=?,supportTeamId=? WHERE creatorId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(creator.getCustomerId()));
            stmt.setInt(2, Integer.parseInt(creator.getSupportTeamId()));
            stmt.setInt(3, Integer.parseInt(creator.getCreatorId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }



}