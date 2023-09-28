package com.inventine.dao.interface_;

import com.inventine.model.AcceptMeeting;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface AcceptMeetingDaoInterface{

    public boolean create(AcceptMeeting acceptMeeting);

    public AcceptMeeting getAcceptMeeting(String acceptMeetingId);

    public List<AcceptMeeting> getAcceptMeetings(String condition);

    public boolean update(AcceptMeeting acceptMeeting);

    public int getCount(String condition) throws SQLException;

}