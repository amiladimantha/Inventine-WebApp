package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class RateProject {
    private String rateProjectId;
    private String projectId;
    private String investorId;
    private int projectRating;
    private Timestamp createdAt;
    private DataValidator validator = new DataValidator();

    public String getRateProjectId(){return rateProjectId;}

    public boolean setRateProjectId(String rateProjectId){
        this.validator.setTxt(rateProjectId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()){
            this.rateProjectId = rateProjectId;
            return true;
        }

        return false;
    }

    public String getProjectId(){ return projectId;}

    public boolean setProjectId(String projectId) {
        this.validator.setTxt(projectId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.projectId = projectId;
            return true;
        }

        return false;
    }

    public String getInvestorId(){ return investorId;}

    public boolean setInvestorId(String investorId) {
        this.validator.setTxt(investorId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.investorId = investorId;
            return true;
        }

        return false;
    }

    public int getProjectRating(){return projectRating;}

    public boolean setProjectRating(int projectRating){
        this.validator.setMaxLength(2);

        if (projectRating >= 0) {
            this.projectRating = projectRating;
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
