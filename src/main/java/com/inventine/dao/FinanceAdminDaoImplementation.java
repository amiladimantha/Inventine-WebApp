package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.FinanceAdminDaoInterface;
import com.inventine.model.FinanceAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinanceAdminDaoImplementation implements FinanceAdminDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from financeadmin";

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
    public boolean create(FinanceAdmin financeAdmin) {

        String query = "INSERT INTO financeAdmin(employeeId) " +
                "VALUES (?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(financeAdmin.getEmployeeId()));


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private FinanceAdmin setFinanceAdmin(FinanceAdmin financeAdmin, ResultSet rs) {

        try {

            financeAdmin.setFinanceAdminId(rs.getString("financeAdminId"));
            financeAdmin.setEmployeeId(rs.getString("employeeId"));


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return financeAdmin;
    }

    @Override
    public FinanceAdmin getFinanceAdmin(String financeAdminId) {

        String query = "SELECT * FROM FinanceAdmin WHERE financeAdminId= ?";

        FinanceAdmin financeAdmin = new FinanceAdmin();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(financeAdminId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                financeAdmin = setFinanceAdmin(financeAdmin,rs);
            }

            return financeAdmin;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<FinanceAdmin> getFinanceAdmins(String condition) {

        String query = "SELECT * FROM financeAdmin";

        List<FinanceAdmin> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FinanceAdmin financeAdmin = new FinanceAdmin();
                financeAdmin = setFinanceAdmin(financeAdmin,rs);
                ls.add(financeAdmin);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(FinanceAdmin financeAdmin) {

        String query = String.format("UPDATE financeAdmin SET employeeId=? WHERE financeAdminId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(financeAdmin.getEmployeeId()));
            stmt.setInt(2, Integer.parseInt(financeAdmin.getFinanceAdminId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }
}
