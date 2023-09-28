package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.VerificationDoaInterface;
import com.inventine.model.Creds;
import com.inventine.model.Verification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VerificationDoaImplementation implements VerificationDoaInterface {

        static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from verification";

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
    public boolean create(Verification verification) {


        String query = "INSERT INTO verification(subid, proofid, pdfid)" +
                "VALUES (?,?,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);


            stmt.setInt(1, Integer.parseInt(verification.getSubId()));
            stmt.setInt(2, Integer.parseInt(verification.getProofId()));
            stmt.setInt(3, Integer.parseInt(verification.getPdfId()));



            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Verification setVerification(Verification verification, ResultSet rs) {

        try {

            verification.setId(rs.getString("id"));
            verification.setSubId(rs.getString("subId"));
            verification.setProofId("proofId");
            verification.setPdfId("pdfId");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return verification;
    }

    @Override
    public Verification getVerification(String id) {

        String query = String.format("SELECT * FROM verification WHERE id=?");

        Verification verification = new Verification();
        boolean found = false;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(id));

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                verification = setVerification(verification, rs);
            }

            return verification;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public List<Verification> getVerifications(String condition) {

        String query = "SELECT * FROM verifications";

        if (!condition.isEmpty()){

            condition = String.format(" WHERE %s",condition);

            query = query.concat(condition);

        }

        List<Verification> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Verification verification =  new Verification();
                verification = setVerification(verification, rs);
                ls.add(verification);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }

    @Override
    public boolean update(Verification verification) {

        String query = String.format("UPDATE verification SET subid=?, proofid=?, pdfid=?, " +
                "WHERE id=?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, String.valueOf(verification.getSubId()));
            stmt.setString(2, String.valueOf(verification.getProofId()));
            stmt.setString(3, String.valueOf(verification.getPdfId()));
            stmt.setString(4, String.valueOf(verification.getId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

}
