package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeetingTest {
    Meeting meeting;

    @BeforeEach
    void setUp() {
        this.meeting = new Meeting();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Meeting.csv", numLinesToSkip = 1)
    void getterSetter(String meeting_id, String creator_id, Timestamp created_at, Timestamp launched_at, String link, String description, char status) {

        this.meeting.setMeetingId(meeting_id);
        this.meeting.setCreatorId(creator_id);
        this.meeting.setCreatedAt(created_at);
        this.meeting.setLaunchedAt(launched_at);
        this.meeting.setLink(link);
        this.meeting.setDescription(description);
        this.meeting.setStatus(status);


        assertEquals(meeting_id, this.meeting.getMeetingId());
        assertEquals(creator_id, this.meeting.getCreatorId());
        assertEquals(created_at, this.meeting.getCreatedAt());
        assertEquals(launched_at, this.meeting.getLaunchedAt());
        assertEquals(link, this.meeting.getLink());
        assertEquals(description, this.meeting.getDescription());
        assertEquals(status, this.meeting.getStatus());
    }
}
