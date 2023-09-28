package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.PayoutDaoInterface;
import com.inventine.model.Payout;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayoutDaoImplementation implements PayoutDaoInterface {

    static Connection conn = DBManager.getConnection();


    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from payout";

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
    public  int getCountAmount(String condition){
        int count = 0;
        String query = "select sum (amount) from payout";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);
            query = query.concat(condition);

        }

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            count = rs.getInt("sum");
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
    public boolean create(Payout payout) {

        String query = "INSERT INTO payout(financeDetailsId, financeAdminId, amount, transactionId) " +
                "VALUES (?, ?,?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(payout.getFinanceDetailsId()));
            stmt.setInt(2, Integer.parseInt(payout.getFinanceAdminId()));
            stmt.setInt(3, payout.getAmount());
            stmt.setInt(4, Integer.parseInt(payout.getTransactionId()));


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    private Payout setPayout(Payout payout, ResultSet rs) {

        try {

            payout.setFinanceAdminId(rs.getString("financeAdminId"));
            payout.setFinanceDetailsId(rs.getString("financeDetailsId"));
            payout.setAmount(rs.getInt("amount"));
            payout.setTransactionId(rs.getString("transactionId"));
            payout.setCreatedAt(rs.getTimestamp("createDate"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payout;
    }

    @Override
    public Payout getPayout(String transactionId) {

        String query = "SELECT * FROM payout WHERE transactionId= ?";

        Payout payout = new Payout();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(transactionId));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                payout = setPayout(payout, rs);
            }

            return payout;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override

    public List<Payout> getPayouts(String condition) {


        String query = "SELECT * FROM payout";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);

            query = query.concat(condition);

        }

        List<Payout> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Payout payout = new Payout();
                payout = setPayout(payout, rs);
                ls.add(payout);
            }


            return ls;


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public boolean update(Payout payout) {

        String query = String.format("UPDATE payout SET financeDetailsId=?, financeAdminId=?, amount=? WHERE transactionId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(payout.getFinanceDetailsId()));
            stmt.setInt(2, Integer.parseInt(payout.getFinanceAdminId()));
            stmt.setInt(4, payout.getAmount());
            stmt.setInt(4, Integer.parseInt(payout.getTransactionId()));


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }




}