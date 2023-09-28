package com.inventine.dao.interface_;

import com.inventine.model.RateProject;

import java.sql.SQLException;
import java.util.List;

public interface RateProjectDaoInterface{

    public boolean create(RateProject rateProject);

    public RateProject getRateProject(String rateProjectId);

    public List<RateProject> getRateProjects(String condition);

    public boolean update(RateProject rateProject);

    public int getCount(String condition) throws SQLException;

}