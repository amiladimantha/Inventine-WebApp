package com.inventine.dao.interface_;

import com.inventine.model.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ProjectDaoInterface{

    public boolean create(Project project);

    public Project getProject(String projectId);

    public List<Project> getProjects(String condition);

    public boolean update(Project project);

    public int getCount(String condition) throws SQLException;

}