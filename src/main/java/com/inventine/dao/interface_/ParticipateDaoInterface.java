package com.inventine.dao.interface_;

import com.inventine.model.Participate;

import java.sql.SQLException;
import java.util.List;

public interface ParticipateDaoInterface {
    public boolean create(Participate participate);

    public Participate getParticipate(String participateId);

    public List<Participate> getParticipates(String condition);

    public boolean update(Participate participate);

    public int getCount(String condition) throws SQLException;



}
