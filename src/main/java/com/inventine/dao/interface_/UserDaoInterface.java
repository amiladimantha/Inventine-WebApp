package com.inventine.dao.interface_;

import com.inventine.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDaoInterface {

    public int getCount(String condition);

    public boolean create(User user);

    public User getUser(String username);

    public List<User> getUsers(String condition);

    public boolean update(User user);

}
