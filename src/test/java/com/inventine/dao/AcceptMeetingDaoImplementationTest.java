package com.inventine.dao;

import com.inventine.model.AcceptMeeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AcceptMeetingDaoImplementationTest {

    AcceptMeeting acceptMeeting;
    AcceptMeetingDaoImplementation acceptMeetingDao;
    @BeforeEach
    void setUp() {

        this.acceptMeeting = new AcceptMeeting();
        this.acceptMeetingDao = new AcceptMeetingDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(acceptMeetingDao.getCount("investorid=1"),6);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/AcceptMeeting.csv", numLinesToSkip = 1)
    void create(String accept_meeting_id, String investor_id, String meeting_id, Timestamp created_at) {

        this.acceptMeeting.setAcceptMeetingId(accept_meeting_id);
        this.acceptMeeting.setInvestorId(investor_id);
        this.acceptMeeting.setMeetingId(meeting_id);
        this.acceptMeeting.setCreatedAt(created_at);


        assertTrue(this.acceptMeetingDao.create(acceptMeeting));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/AcceptMeeting.csv", numLinesToSkip = 1)
    void getAcceptMeeting(String accept_meeting_id, String investor_id, String meeting_id, Timestamp created_at) {

        this.acceptMeeting = this.acceptMeetingDao.getAcceptMeeting(accept_meeting_id);


        assertEquals(accept_meeting_id, this.acceptMeeting.getAcceptMeetingId());
        assertEquals(investor_id, this.acceptMeeting.getInvestorId());
        assertEquals(meeting_id, this.acceptMeeting.getMeetingId());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/AcceptMeeting.csv", numLinesToSkip = 1)
    void getAcceptMeetings(String accept_meeting_id, String investor_id, String meeting_id, Timestamp created_at) {

        List<AcceptMeeting> ls = this.acceptMeetingDao.getAcceptMeetings("investorid=1");

        this.acceptMeeting.setAcceptMeetingId(accept_meeting_id);
        this.acceptMeeting.setInvestorId(investor_id);
        this.acceptMeeting.setMeetingId(meeting_id);

        assertEquals(ls.get(0).getAcceptMeetingId(),this.acceptMeeting.getAcceptMeetingId());
        assertEquals(ls.get(0).getInvestorId(),this.acceptMeeting.getInvestorId());
        assertEquals(ls.get(0).getMeetingId(),this.acceptMeeting.getMeetingId());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/AcceptMeeting.csv", numLinesToSkip = 1)
    void update(String accept_meeting_id, String investor_id, String meeting_id, Timestamp created_at) {

        this.acceptMeeting.setAcceptMeetingId(accept_meeting_id);
        this.acceptMeeting.setInvestorId(investor_id);
        this.acceptMeeting.setMeetingId(meeting_id);


        this.acceptMeetingDao.update(this.acceptMeeting);

        AcceptMeeting updated = this.acceptMeetingDao.getAcceptMeeting(accept_meeting_id);

        assertEquals(this.acceptMeeting.getAcceptMeetingId(),updated.getAcceptMeetingId());
        assertEquals(this.acceptMeeting.getInvestorId(),updated.getInvestorId());
        assertEquals(this.acceptMeeting.getMeetingId(),updated.getMeetingId());


    }

}