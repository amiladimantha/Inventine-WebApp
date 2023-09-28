package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class RateCreator {
    private String rateCreatorId;
    private String creatorId;
    private String investorId;
    private int creatorRating;
    private Timestamp createdAt;
    private DataValidator validator = new DataValidator();

    public String getRateCreatorId(){return rateCreatorId;}

    public boolean setRateCreatorId(String rateCreatorId){
        this.validator.setTxt(rateCreatorId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()){
            this.rateCreatorId = rateCreatorId;
            return true;
        }

        return false;
    }

    public String getCreatorId(){ return creatorId;}

    public boolean setCreatorId(String creatorId) {
        this.validator.setTxt(creatorId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.creatorId = creatorId;
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

    public int getCreatorRating(){return creatorRating;}

    public boolean setCreatorRating(int creatorRating){
        this.validator.setMaxLength(2);

        if (creatorRating >= 0) {
            this.creatorRating = creatorRating;
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
