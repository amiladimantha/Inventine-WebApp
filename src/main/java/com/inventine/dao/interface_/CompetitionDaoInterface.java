package com.inventine.dao.interface_;

import com.inventine.model.Competition;

import java.sql.SQLException;
import java.util.List;

public interface CompetitionDaoInterface {
    public boolean create(Competition competition);

    public Competition getCompetition(String competitionId);

    public List<Competition> getCompetitions(String condition);

    public boolean update(Competition competition);

    public int getCount(String condition) throws SQLException;



}
