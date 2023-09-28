package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Participate {
    private String participateId;
    private Timestamp createdAt;
    private String competitionId;
    private String projectId;
    private DataValidator validator = new DataValidator();

    public String getParticipateId() {
        return participateId;
    }

    public boolean setParticipateId(String participateId) {
        this.validator.setTxt(participateId);
        this.validator.setMaxLength(6);

        if(this.validator.isNumber())
        {
            this.participateId = participateId;
            return true;
        }
        return false;
    }

    public Timestamp getCreatedAt() {

        return createdAt;
    }

    public boolean setCreatedAt(Timestamp createdAt) {

        try{
            this.createdAt = createdAt;
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }




    public   boolean setCompetitionId(String competitionId) {

        this.validator.setTxt(competitionId);
        this.validator.setMaxLength(6);


        if(this.validator.isNumber())
        {
            this.competitionId = competitionId;
            return true;
        }
        return false;
    }

    public String getProjectId() {
        return projectId;
    }

    public boolean setProjectId(String projectId) {
        this.validator.setTxt(projectId);
        this.validator.setMaxLength(6);

        if(this.validator.isNumber())
        {
            this.projectId = projectId;
            return true;
        }
        return false;
    }

    public String getCompetitionId() {
        return competitionId;
    }
}
