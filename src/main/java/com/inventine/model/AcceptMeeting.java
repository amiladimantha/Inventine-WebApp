package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class AcceptMeeting {
    private String acceptMeetingId;
    private String investorId;
    private String meetingId;
    private Timestamp createdAt;
    private DataValidator validator = new DataValidator();

    public String getAcceptMeetingId(){return acceptMeetingId;}

    public boolean setAcceptMeetingId(String acceptMeetingId){
        this.validator.setTxt(acceptMeetingId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()){
            this.acceptMeetingId = acceptMeetingId;
            return true;
        }

        return false;
    }

    public String getInvestorId() {return investorId;}

    public boolean setInvestorId(String investorId) {
        this.validator.setTxt(investorId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.investorId = investorId;
            return true;
        }

        return false;
    }

    public String getMeetingId(){ return meetingId;}

    public boolean setMeetingId(String meetingId) {
        this.validator.setTxt(meetingId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.meetingId = meetingId;
            return true;
        }

        return false;
    }

    public Timestamp getCreatedAt(){return createdAt;}

    public boolean setCreatedAt(Timestamp createdAt){
        try{
            this.createdAt = createdAt;

        }catch (Exception e){
            return true;
        }

        return false;
    }
}
