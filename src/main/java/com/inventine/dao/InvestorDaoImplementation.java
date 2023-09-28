package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.InvestorDaoInterface;
import com.inventine.model.Investor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestorDaoImplementation implements InvestorDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from investor";

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
    public boolean create(Investor investor) {

        String query = "INSERT INTO investor( customerId) " +
                "VALUES (?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(investor.getCustomerId()));


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private Investor setInvestor(Investor investor, ResultSet rs) {

        try {

            investor.setInvestorId(rs.getString("investorId"));
            investor.setCustomerId(rs.getString("customerId"));



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return investor;
    }

    @Override
    public Investor getInvestor(String investorId) {

        String query = "SELECT * FROM investor WHERE investorId= ?";

        Investor investor = new Investor();


        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(investorId));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                investor = setInvestor(investor, rs);
            }


            return investor;

        } catch (SQLException e) {
            e.printStackTrace();
        }


            return null;

    }

    @Override

    public List<Investor> getInvestors(String condition) {


        String query = "SELECT * FROM investor";

        List<Investor> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Investor investor = new Investor();
                investor = setInvestor(investor, rs);
                ls.add(investor);
            }


            return  ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;

    }

    @Override
    public boolean update(Investor investor) {

        String query = String.format("UPDATE investor SET customerId=? WHERE investorId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(investor.getCustomerId()));
            stmt.setInt(2, Integer.parseInt(investor.getInvestorId()));


            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }


}
