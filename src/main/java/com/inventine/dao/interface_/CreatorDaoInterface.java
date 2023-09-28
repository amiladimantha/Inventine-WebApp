package com.inventine.dao.interface_;

import com.inventine.model.Creator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CreatorDaoInterface{

    public boolean create(Creator creator);

    public Creator getCreator(String creatorId);

    public List<Creator> getCreators(String condition);

    public boolean update(Creator creator);

    public int getCount(String condition) throws SQLException;

    public ResultSet executeQuery(String query);

}