package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.RefundDaoInterface;
import com.inventine.model.Refund;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RefundDaoImplementation implements RefundDaoInterface {


    static Connection conn = DBManager.getConnection();


    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from refund";

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
    public boolean create(Refund refund) {

        String query = "INSERT INTO refund(financeAdminId, paymentId) " +
                "VALUES (?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(refund.getFinanceAdminId()));
            stmt.setInt(2, Integer.parseInt(refund.getPaymentId()));


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    private Refund setRefund(Refund refund, ResultSet rs) {

        try {

            refund.setRefundId(rs.getString("refundId"));
            refund.setFinanceAdminId(rs.getString("financeAdminId"));
            refund.setPaymentId(rs.getString("paymentId"));
            refund.setCreatedAt(rs.getTimestamp("createDate"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return refund;
    }

    @Override
    public Refund getRefund(String refundId) {

        String query = "SELECT * FROM Refund WHERE refundId= ?";

        Refund refund = new Refund();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(refundId));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                refund = setRefund(refund,rs);
            }

            return refund;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override

    public List<Refund> getRefunds(String condition) {


        String query = "SELECT * FROM refund";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);

            query = query.concat(condition);

        }

        List<Refund> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Refund refund = new Refund();
                refund = setRefund(refund,rs);
                ls.add(refund);
            }


            return ls;


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public boolean update(Refund refund) {

        String query = String.format("UPDATE refund SET  financeAdminId=?, paymentId=? WHERE refundId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);



            stmt.setInt(1, Integer.parseInt(refund.getFinanceAdminId()));
            stmt.setInt(2, Integer.parseInt(refund.getPaymentId()));
            stmt.setInt(3, Integer.parseInt(refund.getRefundId()));


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
