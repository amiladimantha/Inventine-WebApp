package com.inventine.dao.interface_;

import com.inventine.model.Submit;

import java.sql.SQLException;
import java.util.List;

public interface SubmitDaoInterface {
    public boolean create(Submit submit);

    public Submit getSubmit(String submitId);

    public List<Submit> getSubmits(String condition);

    public boolean update(Submit submit);

    public int getCount(String condition) throws SQLException;



}
