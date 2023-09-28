package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.RateCreatorDaoInterface;
import com.inventine.model.RateCreator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RateCreatorDaoImplementation implements RateCreatorDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from rateCreator";

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
    public boolean create(RateCreator rateCreator) {

        String query = "INSERT INTO RateCreator( creatorId, investorId, creatorRating) " +
                "VALUES (?, ?, ?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(rateCreator.getCreatorId()));
            stmt.setInt(2, Integer.parseInt(rateCreator.getInvestorId()));
            stmt.setString(3, String.valueOf(rateCreator.getCreatorRating()));



            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();        }

            return false;

    }

    private RateCreator setRateCreator(RateCreator rateCreator, ResultSet rs) {

        try {

            rateCreator.setRateCreatorId(rs.getString("rateCreatorId"));
            rateCreator.setCreatorId(rs.getString("creatorId"));
            rateCreator.setInvestorId(rs.getString("investorId"));
            rateCreator.setCreatorRating(rs.getInt("creatorRating"));
            rateCreator.setCreatedAt(rs.getTimestamp("createdAt"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rateCreator;
    }

    @Override
    public RateCreator getRateCreator(String rateCreatorId) {

        String query = "SELECT * FROM rateCreator WHERE rateCreatorId= ?";

        RateCreator rateCreator = new RateCreator();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(rateCreatorId));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                rateCreator = setRateCreator(rateCreator, rs);
            }


            return rateCreator;


        } catch (SQLException e) {
            e.printStackTrace();
        }


            return null;

    }

    @Override

    public List<RateCreator> getRateCreators(String condition) {


        String query = "SELECT * FROM rateCreator";

        List<RateCreator> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RateCreator rateCreator = new RateCreator();
                rateCreator = setRateCreator(rateCreator, rs);
                ls.add(rateCreator);
            }


            return ls;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public boolean update(RateCreator rateCreator) {

        String query = String.format("UPDATE rateCreator SET creatorId=?, investorId=?, creatorRating=? WHERE rateCreatorId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);



            stmt.setInt(1, Integer.parseInt(rateCreator.getCreatorId()));
            stmt.setInt(2, Integer.parseInt(rateCreator.getInvestorId()));
            stmt.setInt(3, rateCreator.getCreatorRating());
            stmt.setInt(4, Integer.parseInt(rateCreator.getRateCreatorId()));


            stmt.executeUpdate();

            return  true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }


}