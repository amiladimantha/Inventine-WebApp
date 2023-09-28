package com.inventine.dao;

import com.inventine.model.Meeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingDaoImplementationTest {

    Meeting meeting;
    MeetingDaoImplementation meetingDao;
    @BeforeEach
    void setUp() {

        this.meeting = new Meeting();
        this.meetingDao = new MeetingDaoImplementation();
    }
    @Test
    void getCount() {
        assertEquals(meetingDao.getCount("creatorid=3"),2);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Meeting.csv", numLinesToSkip = 1)
    void create(String meeting_id, String creator_id, Timestamp created_at, Timestamp launched_at, String link, String description, char status) {

        this.meeting.setMeetingId(meeting_id);
        this.meeting.setCreatorId(creator_id);
        this.meeting.setCreatedAt(created_at);
        this.meeting.setLaunchedAt(launched_at);
        this.meeting.setLink(link);
        this.meeting.setDescription(description);
        this.meeting.setStatus(status);



        assertTrue(this.meetingDao.create(meeting));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Meeting.csv", numLinesToSkip = 1)
    void getMeeting(String meeting_id, String creator_id, Timestamp created_at, Timestamp launched_at, String link, String description, char status) {

        this.meeting = this.meetingDao.getMeeting(meeting_id);

        assertEquals(meeting_id, this.meeting.getMeetingId());
        assertEquals(creator_id, this.meeting.getCreatorId());
        assertEquals(launched_at, this.meeting.getLaunchedAt());
        assertEquals(link, this.meeting.getLink());
        assertEquals(description, this.meeting.getDescription());
        assertEquals(status, this.meeting.getStatus());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Meeting.csv", numLinesToSkip = 1)
    void getMeetings(String meeting_id, String creator_id, Timestamp created_at, Timestamp launched_at, String link, String description, char status) {

        List<Meeting> ls = this.meetingDao.getMeetings("creatorid=3");

        this.meeting.setMeetingId(meeting_id);
        this.meeting.setCreatorId(creator_id);
        this.meeting.setLaunchedAt(launched_at);
        this.meeting.setLink(link);
        this.meeting.setDescription(description);
        this.meeting.setStatus(status);


        assertEquals(ls.get(0).getMeetingId(),this.meeting.getMeetingId());
        assertEquals(ls.get(0).getCreatorId(),this.meeting.getCreatorId());
        assertEquals(ls.get(0).getLaunchedAt(),this.meeting.getLaunchedAt());
        assertEquals(ls.get(0).getLink(),this.meeting.getLink());
        assertEquals(ls.get(0).getDescription(),this.meeting.getDescription());
        assertEquals(ls.get(0).getStatus(),this.meeting.getStatus());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Meeting.csv", numLinesToSkip = 1)
    void update(String meeting_id, String creator_id, Timestamp created_at, Timestamp launched_at, String link, String description, char status) {

        this.meeting.setMeetingId(meeting_id);
        this.meeting.setCreatorId(creator_id);
        this.meeting.setLaunchedAt(launched_at);
        this.meeting.setLink(link);
        this.meeting.setDescription(description);
        this.meeting.setStatus(status);


        this.meetingDao.update(this.meeting);

        Meeting updated = this.meetingDao.getMeeting(meeting_id);

        assertEquals(this.meeting.getMeetingId(),updated.getMeetingId());
        assertEquals(this.meeting.getCreatorId(),updated.getCreatorId());
        assertEquals(this.meeting.getLaunchedAt(),updated.getLaunchedAt());
        assertEquals(this.meeting.getLink(),updated.getLink());
        assertEquals(this.meeting.getDescription(),updated.getDescription());
        assertEquals(this.meeting.getStatus(),updated.getStatus());


    }

}