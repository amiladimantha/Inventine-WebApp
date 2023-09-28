package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.CredsDaoInterface;
import com.inventine.model.Creds;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CredsDaoImplementation implements CredsDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from creds";

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
    public int create(Creds creds) {

      
        String query = "INSERT INTO creds(username, email, password, role, status)" +
                "VALUES (?, ?,?, CAST(? AS rl),CAST(? AS sts)) RETURNING userid" ;

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setString(1, creds.getUsername());
            stmt.setString(2, creds.getEmail());
            stmt.setString(3, creds.getPassword());
            stmt.setString(4, String.valueOf(creds.getRole()));
            stmt.setString(5, String.valueOf(creds.getStatus()));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                n = rs.getInt("userid");
            }

            return n;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private Creds setCreds(Creds creds, ResultSet rs) {

        try {

            creds.setUserId(rs.getString("userid"));
            creds.setUsername(rs.getString("username"));
            creds.setEmail(rs.getString("email"));
            creds.setPassword(rs.getString("password"));
            creds.setRole(rs.getString("role").charAt(0));
            creds.setStatus(rs.getString("status").charAt(0));
            creds.setCreatedAt(rs.getTimestamp("createdAt"));
            creds.setProfileId((rs.getString("profileId")));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return creds;
    }

    @Override
    public Creds getCreds(String userid) {

        String query = String.format("SELECT * FROM creds WHERE userid=?");

        Creds creds = new Creds();
        boolean found = false;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(userid));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                creds = setCreds(creds, rs);
            }

            return creds;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public List<Creds> getManyCreds(String condition) {

        String query = "SELECT * FROM creds";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);

            query = query.concat(condition);

        }

        List<Creds> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Creds creds = new Creds();
                creds = setCreds(creds, rs);
                ls.add(creds);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }

    @Override
    public boolean update(Creds creds) {

        String query = String.format("UPDATE creds SET username=?, email=?, password=?, " +
                "role=CAST(? AS rl), status=CAST(? AS sts), profileId=? WHERE userid=?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, creds.getUsername());
            stmt.setString(2, creds.getEmail());
            stmt.setString(3, creds.getPassword());
            stmt.setString(4, String.valueOf(creds.getRole()));
            stmt.setString(5, String.valueOf(creds.getStatus()));
            stmt.setInt(6, Integer.parseInt(creds.getUserId()));
            stmt.setString(7, creds.getProfileId());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }


}
