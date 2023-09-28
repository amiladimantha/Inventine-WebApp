package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class ChatTest {

    Chat chat;

    @BeforeEach
    void setUp() {
        this.chat = new Chat();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Chat.csv", numLinesToSkip = 1)
    void getterSetter(String chat_id, String sender_id,String receiver_id, String message, Timestamp created_at) {

        this.chat.setChatId(chat_id);
        this.chat.setSenderId(sender_id);
        this.chat.setReceiverId(receiver_id);
        this.chat.setMessage(message);
        this.chat.setCreatedAt(created_at);

        assertEquals(chat_id, this.chat.getChatId());
        assertEquals(sender_id, this.chat.getSenderId());
        assertEquals(receiver_id, this.chat.getReceiverId());
        assertEquals(message, this.chat.getMessage());
        assertEquals(created_at, this.chat.getCreatedAt());









    }

}