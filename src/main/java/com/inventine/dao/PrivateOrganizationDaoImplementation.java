package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.PrivateOrganizationDaoInterface;
import com.inventine.model.PrivateOrganization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrivateOrganizationDaoImplementation implements PrivateOrganizationDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from privateOrganization";

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
    public boolean create(PrivateOrganization privateOrganization) {

        String query = "INSERT INTO PrivateOrganization(  organizationId,regNo) " +
                "VALUES ( ?,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(privateOrganization.getOrganizationId()));
             stmt.setString(2,privateOrganization.getRegNo());



            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private PrivateOrganization setPrivateOrganization(PrivateOrganization privateOrganization, ResultSet rs) {

        try {

            privateOrganization.setPrivateOrganizationId(rs.getString("privateOrganizationId"));
            privateOrganization.setOrganizationId(rs.getString("organizationId"));
            privateOrganization.setRegNo(rs.getString("regNo"));



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return privateOrganization;
    }

    @Override
    public PrivateOrganization getPrivateOrganization(String privateOrganizationId) {

        String query = "SELECT * FROM PrivateOrganization WHERE privateOrganizationId= ?";

        PrivateOrganization privateOrganization = new PrivateOrganization();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(privateOrganizationId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                privateOrganization = setPrivateOrganization(privateOrganization, rs);
            }

            return privateOrganization;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<PrivateOrganization> getPrivateOrganizations(String condition) {

        String query = "SELECT * FROM privateOrganization";

        List<PrivateOrganization> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                PrivateOrganization privateOrganization = new PrivateOrganization();
                privateOrganization = setPrivateOrganization(privateOrganization, rs);
                ls.add(privateOrganization);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(PrivateOrganization privateOrganization) {

        String query = String.format("UPDATE privateOrganization SET organizationId=?,regNo=? WHERE privateOrganizationId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(privateOrganization.getOrganizationId()));
            stmt.setString(2, privateOrganization.getRegNo());
            stmt.setInt(3, Integer.parseInt(privateOrganization.getPrivateOrganizationId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }



}
