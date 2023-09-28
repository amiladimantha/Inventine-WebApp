package com.inventine.dao;

import com.inventine.conf.DBManager;
import com.inventine.dao.interface_.ChatDaoInterface;
import com.inventine.model.Chat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChatDaoImplementation implements ChatDaoInterface {

    static Connection conn = DBManager.getConnection();

    @Override
    public int getCount(String condition)  {

        int count = 0;
        String query = "select count(*) from chat";

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
    public boolean create(Chat chat) {

        String query = "INSERT INTO Chat( senderId, receiverId,messages) " +
                "VALUES (?, ?,?)";

        int n = 0;

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(chat.getSenderId()));
            stmt.setInt(2, Integer.parseInt(chat.getReceiverId()));
            stmt.setString(3, chat.getMessage());


            n = stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();  }

        return false;

    }

    private Chat setChat(Chat chat, ResultSet rs) {

        try {

            chat.setChatId(rs.getString("chatId"));
            chat.setSenderId(rs.getString("senderId"));
            chat.setReceiverId(rs.getString("receiverId"));
            chat.setMessage(rs.getString("messages"));
            chat.setCreatedAt(rs.getTimestamp("createdAt"));

            System.out.println(chat.getChatId());
            System.out.println(chat.getSenderId());
            System.out.println(chat.getReceiverId());
            System.out.println(chat.getMessage());
            System.out.println(chat.getCreatedAt());


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chat;
    }

    @Override
    public Chat getChat(String chatId) {

        String query = "SELECT * FROM Chat WHERE chatId= ?";

        Chat chat = new Chat();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1,Integer.parseInt(chatId));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                chat = setChat(chat, rs);
            }

            return chat;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<Chat> getChats(String condition) {

        String query = "SELECT * FROM chat";

        List<Chat> ls = new ArrayList();

        try {

            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Chat chat = new Chat();
                chat = setChat(chat, rs);
                ls.add(chat);
            }

            return ls;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Chat chat) {

        String query = String.format("UPDATE chat SET senderId=?,receiverId=?,messages=? WHERE chatId =?");

        try {

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, Integer.parseInt(chat.getSenderId()));
            stmt.setInt(2, Integer.parseInt(chat.getReceiverId()));
            stmt.setString(3, chat.getMessage());
            stmt.setInt(4, Integer.parseInt(chat.getChatId()));

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }



}
