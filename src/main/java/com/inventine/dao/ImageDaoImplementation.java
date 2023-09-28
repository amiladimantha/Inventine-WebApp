package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.ImageDaoInterface;
import com.inventine.model.Image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Base64;

public class ImageDaoImplementation implements ImageDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public boolean create(Image image)  {

        String query = "INSERT INTO Image(id,content_type,size,data) " +
                "VALUES (?,?,?,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,image.getId());
            stmt.setString(2,image.getContentType());
            stmt.setInt(3,image.getSize());
            stmt.setBytes(4,image.getData());

            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;


    }

    @Override
    public Image getImage(String id)  {

        String query = "SELECT * FROM Image WHERE id=?";

        Image image = new Image();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                image.setId(rs.getString("id"));
                image.setContentType(rs.getString("content_type"));
                image.setSize(rs.getInt("size"));
                image.setData(rs.getBytes("data"));

            }

            return image;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public boolean delete(Image image)  {

        String query = "DELETE * FROM Image WHERE id=?";

        image = new Image();

        try{

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1,String.valueOf(image.getId()));
            ResultSet rs = stmt.executeQuery();

            return true;

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

}
