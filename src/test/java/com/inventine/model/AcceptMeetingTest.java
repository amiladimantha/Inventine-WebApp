package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class AcceptMeetingTest {
    AcceptMeeting acceptMeeting;

    @BeforeEach
    void setUp() {
        this.acceptMeeting = new AcceptMeeting();
    }



    @ParameterizedTest
    @CsvFileSource(resources = "/model/AcceptMeeting.csv", numLinesToSkip = 1)
    void getterSetter( String accept_meeting_id, String investor_id, String meeting_id, Timestamp created_at) {

        this.acceptMeeting.setAcceptMeetingId(accept_meeting_id);
        this.acceptMeeting.setInvestorId(investor_id);
        this.acceptMeeting.setMeetingId(meeting_id);
        this.acceptMeeting.setCreatedAt(created_at);


        assertEquals(accept_meeting_id,this.acceptMeeting.getAcceptMeetingId());
        assertEquals(investor_id,this.acceptMeeting.getInvestorId());
        assertEquals(meeting_id,this.acceptMeeting.getMeetingId());
        assertEquals(created_at,this.acceptMeeting.getCreatedAt());

    }



}