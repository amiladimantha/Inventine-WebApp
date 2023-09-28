package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.PaymentDaoInterface;
import com.inventine.model.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImplementation implements PaymentDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from payment";

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
        String query = "select sum (amount) from payment";

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
    public boolean create(Payment payment) {

        String query = "INSERT INTO Payment(projectId, investorId, financialDetailsId, amount) " +
                "VALUES (?, ?, ?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(payment.getProjectId()));
            stmt.setInt(2, Integer.parseInt(payment.getInvestorId()));
            stmt.setInt(3, Integer.parseInt(payment.getFinancialDetailsId()));
            stmt.setString(4, String.valueOf(payment.getAmount()));


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();}

            return false;

    }

    private Payment setPayment(Payment payment, ResultSet rs) {

        try {

            payment.setPaymentId(rs.getString("paymentId"));
            payment.setProjectId(rs.getString("projectId"));
            payment.setInvestorId(rs.getString("investorId"));
            payment.setFinancialDetailsId(rs.getString("financialDetailsId"));
            payment.setAmount(rs.getInt("amount"));
            payment.setCreatedAt(rs.getTimestamp("createdAt"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payment;
    }

    @Override
    public Payment getPayment(String paymentId) {

        String query = "SELECT * FROM payment WHERE paymentId= ?";

        Payment payment = new Payment();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(paymentId));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                payment = setPayment(payment, rs);
            }

            return payment;

        } catch (SQLException e) {
            e.printStackTrace();
        }


            return null;

    }

    @Override

    public List<Payment> getPayments(String condition) {


        String query = "SELECT * FROM payment";

        List<Payment> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Payment payment = new Payment();
                payment = setPayment(payment, rs);
                ls.add(payment);
            }


            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    private Payment setPaymentcountSum(Payment payment, ResultSet rs,String countSum) {

        try {

            payment.setCountSum(rs.getString(countSum));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payment;
    }

    @Override
    public Payment getPaymentCountSum(String query,String countSum) {



        Payment payment = new Payment();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                payment = setPaymentcountSum(payment, rs,countSum);
            }

            return payment;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override
    public boolean update(Payment payment) {

        String query = String.format("UPDATE payment SET projectId=?, investorId=?, financialDetailsId=?, amount=? WHERE paymentId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(payment.getProjectId()));
            stmt.setInt(2, Integer.parseInt(payment.getInvestorId()));
            stmt.setInt(3, Integer.parseInt(payment.getFinancialDetailsId()));
            stmt.setInt(4, payment.getAmount());
            stmt.setInt(4, Integer.parseInt(payment.getPaymentId()));


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



}