package com.inventine.model;

import com.inventine.util.DataValidator;

public class Creator extends User{
    private String creatorId;
    private String customerId;
    private String supportTeamId;
    private DataValidator validator = new DataValidator();

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

    public String getCustomerId(){ return customerId;}

    public boolean setCustomerId(String customerId) {
        this.validator.setTxt(customerId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.customerId = customerId;
            return true;
        }

        return false;
    }

    public String getSupportTeamId(){ return supportTeamId;}

    public boolean setSupportTeamId(String supportTeamId) {
        this.validator.setTxt(supportTeamId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.supportTeamId = supportTeamId;
            return true;
        }

        return false;
    }
}
