package com.inventine.dao.interface_;

import com.inventine.model.ForumReply;
import com.inventine.model.Issues;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IssuesDaoInterface {

    public boolean create(Issues issues);

    public Issues getIssue(String issueId);

    public Issues getIssueCount(String query);


    public List<Issues> getIssues(String condition);

    public boolean update(Issues issues);

    public int getCount(String condition) throws SQLException;

    public ResultSet executeQuery(String query);

}