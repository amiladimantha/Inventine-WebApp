package com.inventine.dao.interface_;

import com.inventine.model.School;

import java.sql.SQLException;
import java.util.List;

public interface SchoolDaoInterface {
    public boolean create(School school);

    public School getSchool(String schoolId);

    public List<School> getSchools(String condition);

    public boolean update(School school);

    public int getCount(String condition) throws SQLException;



}
