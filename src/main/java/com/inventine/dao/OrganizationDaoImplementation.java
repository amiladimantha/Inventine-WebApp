package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.OrganizationDaoInterface;

import com.inventine.model.Organization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganizationDaoImplementation implements OrganizationDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from organization";
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
    public boolean create(Organization organization) {

        String query = "INSERT INTO organization(organizationId, supportTeamId,name,address,district,contactNumber,headerId,logoId, orgType) " +
                "VALUES (?, ?,?,?,?,?,?,?,CAST(? AS org1)) ";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(organization.getOrganizationId()));
            stmt.setInt(2, Integer.parseInt(organization.getSupportTeamId()));
            stmt.setString(3, organization.getName());
            stmt.setString(4, organization.getAddress());
            stmt.setString(5, organization.getDistrict());
            stmt.setString(6, organization.getContactNumber());
            stmt.setString(7,  organization.getHeaderId());
            stmt.setString(8, organization.getLogoId());
            stmt.setString(9, String.valueOf(organization.getOrgType()));



            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private Organization setOrganization(Organization organization, ResultSet rs) {

        try {

            organization.setOrganizationId(rs.getString("organizationId"));
            organization.setSupportTeamId(rs.getString("supportTeamId"));
            organization.setName(rs.getString("name"));
            organization.setAddress(rs.getString("address"));
            organization.setDistrict(rs.getString("district"));
            organization.setContactNumber(rs.getString("contactNumber"));
            organization.setCreatedAt(rs.getTimestamp("createdAt"));
            organization.setHeaderId(rs.getString("headerId"));
            organization.setLogoId(rs.getString("logoId"));
            organization.setOrgType(rs.getString("orgType").charAt(0));











        } catch (SQLException e) {
            e.printStackTrace();
        }

        return organization;
    }

    @Override
    public Organization getOrganization(String organizationId) {

        String query = "SELECT * FROM organization WHERE organizationId= ?";

        Organization organization = new Organization();
        boolean found = false;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(organizationId));


            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                found = true;
                organization = setOrganization(organization, rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (found == true) {
            return organization;
        } else
            return null;

    }

    @Override
    public List<Organization> getOrganizations(String condition){

        String query = "SELECT * FROM organization";

        List<Organization> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Organization organization = new Organization();
                organization = setOrganization(organization, rs);
                ls.add(organization);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ls;
    }
    @Override
    public boolean update(Organization organization) {

        String query = String.format("UPDATE organization SET supportTeamId=?,name=?,address=?,district=?,contactNumber=?,headerId=?,logoId=?,orgType=CAST(? AS org1),WHERE organizationId =?");

        try{

            PreparedStatement stmt = conn.prepareStatement(query);



            stmt.setInt(1, Integer.parseInt(organization.getSupportTeamId()));
            stmt.setString(2, organization.getName());
            stmt.setString(3, organization.getAddress());
            stmt.setString(4, organization.getDistrict());
            stmt.setString(5, organization.getContactNumber());
            stmt.setString(6, organization.getHeaderId());
            stmt.setString(7, organization.getLogoId());
            stmt.setString(8, String.valueOf(organization.getOrgType()));
            stmt.setInt(9, Integer.parseInt(organization.getOrganizationId()));






            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }










}



/* stmt.setString(1, organization.getCreatorId());
            stmt.setString(2, organization.getSupportTeamId());*/