package com.inventine.dao;

import com.inventine.model.Chat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChatDaoImplementationTest {

    Chat chat;
    ChatDaoImplementation chatDao;
    @BeforeEach
    void setUp() {

        this.chat = new Chat();
        this.chatDao = new ChatDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(chatDao.getCount("chatid=3"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Chat.csv", numLinesToSkip = 1)
    void create(String chat_id, String sender_id, String receiver_id, String message, Timestamp created_At) {


        this.chat.setChatId(chat_id);
        this.chat.setSenderId(sender_id);
        this.chat.setReceiverId(receiver_id);
        this.chat.setMessage(message);
        this.chat.setCreatedAt(created_At);


        assertTrue(this.chatDao.create(chat));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Chat.csv", numLinesToSkip = 1)
    void getChat(String chat_id,String sender_id,String receiver_id,String message,Timestamp created_at) {

        this.chat = this.chatDao.getChat(chat_id);

        assertEquals(chat_id, this.chat.getChatId());
        assertEquals(sender_id, this.chat.getSenderId());
        assertEquals(receiver_id, this.chat.getReceiverId());
        assertEquals(message, this.chat.getMessage());
       // assertEquals(created_at, this.chat.getCreatedAt());

    }

//
    @ParameterizedTest
    @CsvFileSource(resources = "/model/Chat.csv", numLinesToSkip = 1)
    void getChats(String chat_id,String sender_id,String receiver_id,String messages,Timestamp created_at) {

        List<Chat> ls = this.chatDao.getChats("chatid=3");

        this.chat.setChatId(chat_id);
        this.chat.setSenderId(sender_id);
        this.chat.setReceiverId(receiver_id);
        this.chat.setMessage(messages);

        assertEquals(ls.get(0).getChatId(),this.chat.getChatId());
        assertEquals(ls.get(0).getSenderId(),this.chat.getSenderId());
        assertEquals(ls.get(0).getReceiverId(),this.chat.getReceiverId());
        assertEquals(ls.get(0).getMessage(),this.chat.getMessage());

    }
//
    @ParameterizedTest
    @CsvFileSource(resources = "/model/Chat.csv", numLinesToSkip = 1)
    void update(String chat_id,String sender_id,String receiver_id,String messages,Timestamp created_at) {

        this.chat.setChatId(chat_id);
        this.chat.setSenderId(sender_id);
        this.chat.setReceiverId(receiver_id);
        this.chat.setMessage(messages);
        //this.chat.setCreatedAt(created_at);

        this.chatDao.update(this.chat);

        Chat updated = this.chatDao.getChat(chat_id);

        assertEquals(this.chat.getChatId(),updated.getChatId());
        assertEquals(this.chat.getSenderId(),updated.getSenderId());
        assertEquals(this.chat.getReceiverId(),updated.getReceiverId());
        assertEquals(this.chat.getMessage(),updated.getMessage());
       //
        // assertEquals(this.chat.getCreatedAt(),updated.getCreatedAt());

    }

}