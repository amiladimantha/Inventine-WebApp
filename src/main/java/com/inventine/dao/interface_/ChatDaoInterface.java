
package com.inventine.dao.interface_;

import com.inventine.model.Chat;

import java.sql.SQLException;
import java.util.List;

public interface ChatDaoInterface {
    public boolean create(Chat chat);

    public Chat getChat(String chatId);

    public List<Chat> getChats(String condition);

    public boolean update(Chat chat);

    public int getCount(String condition) throws SQLException;



}
