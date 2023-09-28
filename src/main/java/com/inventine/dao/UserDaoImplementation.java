package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.UserDaoInterface;
import com.inventine.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplementation implements UserDaoInterface {

    static Connection conn = DBManager.getConnection();


    @Override
    public int getCount(String condition){

        String query = "select count(*) from users";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);

            query.concat(condition);

        }

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            rs.next();

            return rs.getInt("count");

        }catch(SQLException e){

            e.printStackTrace();
            return 0;

        }
    }

    @Override
    public boolean create(User user) {

        String query = "INSERT INTO users(userid, firstName, lastName, dob, gender, phone, address, district, type ) " +
                "VALUES (?, ?, ?,?, CAST(? AS ge),?, ?,?, CAST(? AS te)) RETURNING userid";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(user.getUserId()));
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setTimestamp(4, user.getDob());
            stmt.setString(5, String.valueOf(user.getGender()));
            stmt.setString(6, user.getPhone());
            stmt.setString(7, user.getAddress());
            stmt.setString(8, user.getDistrict());
            stmt.setString(9, String.valueOf(user.getType()));

            ResultSet rs = stmt.executeQuery();


            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    private User setUser(User user, ResultSet rs) {

        try {
            user.setUserId(rs.getString("userId"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setDob(rs.getTimestamp("dob"));
            user.setGender(rs.getString("gender").charAt(0));
            user.setPhone(rs.getString("phone"));
            user.setAddress(rs.getString("address"));
            user.setDistrict(rs.getString("district"));
            user.setType(rs.getString("type").charAt(0));
            user.setCreatedAt(rs.getTimestamp("createdAt"));
            user.setHeaderId(rs.getString("headerId"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getUser(String userId) {

        String query = "SELECT * FROM users WHERE userId= ?";

        User user = new User();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(userId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                user = setUser(user, rs);
            }

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<User> getUsers(String condition) {

        String query = "SELECT * FROM users";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);

            query = query.concat(condition);

        }

        List<User> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user = setUser(user, rs);
                ls.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }

    @Override
    public boolean update(User user) {

        String query = String.format("UPDATE users SET firstName=?, lastName=?, dob=?, gender=CAST(? AS ge), phone=?, address=?, district=?, type=CAST(? AS te), headerId=? WHERE userId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setTimestamp(3, user.getDob());
            stmt.setString(4, String.valueOf(user.getGender()));
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getAddress());
            stmt.setString(7, user.getDistrict());
            stmt.setString(8, String.valueOf(user.getType()));
            stmt.setInt(9, Integer.parseInt(user.getUserId()));
            stmt.setString(10, user.getHeaderId());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

}