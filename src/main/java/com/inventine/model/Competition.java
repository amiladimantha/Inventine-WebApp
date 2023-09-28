package com.inventine.model;

import com.inventine.util.DataValidator;
import java.sql.Timestamp;

public class Competition {
    private String competitionId;
    private String organizationId;
    private String supportTeamId;
    private Timestamp createdAt;
    private Timestamp endingAt;
    private Timestamp startingAt;
    private int prizeMoney;
    private String rules;
    private char cType;
    private char pType;
    private  String competitionName;
    private  String headerId;
    private  String overView;
    private char status;
    private DataValidator validator = new DataValidator();

    public String getHeaderId() {
        return headerId;
    }

    public boolean setHeaderId(String headerId) {

        this.headerId = headerId;
        return true;

     }
    public String getCompetitionName() {
        return competitionName;
    }

    public boolean setCompetitionName(String competitionName) {
        this.validator.setTxt(competitionName);
        this.validator.setMaxLength(255);
        if(this.validator.isString())
        {
            this.competitionName = competitionName;
            return true;
        }
        return false;


    }

    public char getCType() {
        return cType;
    }

    public boolean setCType(char cType) {
        if (cType == 'H' || cType == 'T') {
            this.cType = cType;
            return true;
        }

        return false;

    }

    public char getPType() {
        return pType;
    }

    public boolean setPType(char pType) {
        if(pType == 'I'|| pType== 'A')
        {
            this.pType = pType;
            return true;
        }
        return  false;
    }



    public String getCompetitionId(){ return competitionId;}

    public boolean setCompetitionId(String competitionId) {
        this.validator.setTxt(competitionId);
        this.validator.setMaxLength(6);

        if (this.validator.isNumber()) {
            this.competitionId = competitionId;
            return true;
        }

        return false;
    }

    public Timestamp getCreatedAt(){ return createdAt;}

    public boolean setCreatedAt(Timestamp createdAt){
        try{
            this.createdAt = createdAt;

        }catch (Exception e){
            return true;
        }

        return false;
    }

    public Timestamp getEndingAt(){ return endingAt;}

    public boolean setEndingAt(Timestamp endingAt){
        try{
            this.endingAt = endingAt;

        }catch (Exception e){
            return true;
        }

        return false;
    }

    public Timestamp getStartingAt() {
        return startingAt;
    }

    public boolean setStartingAt(Timestamp startingAt) {
        try {
            this.startingAt = startingAt;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int getPrizeMoney() {return prizeMoney;}

    public boolean setPrizeMoney(int prizeMoney) {

        if (prizeMoney >= 0) {
            this.prizeMoney = prizeMoney;
            return true;
        }
        return false;
    }



    public String getRules(){return rules;}

    public boolean setRules(String rules){



            this.rules = rules;


        return true;
    }

    public String getOverView() {
        return overView;
    }

    public boolean setOverView(String overView) {
        this.overView = overView;
        return true;
    }

    public String getSupportTeamId() {
        return supportTeamId;
    }

    public boolean setSupportTeamId(String supportTeamId) {
        this.validator.setTxt(supportTeamId);
        this.validator.setMaxLength(6);

        if(this.validator.isNumber())
        {
            this.supportTeamId = supportTeamId;
            return true;
        }

         return false;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public boolean setOrganizationId(String organizationId) {
        this.validator.setTxt(organizationId);
        this.validator.setMaxLength(10);
        if(this.validator.isNumber())
        {
            this.organizationId = organizationId;
            return true;
        }
        return false;

    }

//    public String getProjectId() {
//        return projectId;
//    }
//
//    public boolean setProjectId(String projectId) {
//        this.validator.setTxt(projectId);
//        this.validator.setMaxLength(6);
//
//        if(this.validator.isNumber())
//        {
//            this.projectId = projectId;
//            return true;
//        }
//         return false;
//    }

    public char getStatus() {
        return status;
    }

    public boolean setStatus(char status) {
        if(status == 'A'|| status == 'B'|| status == 'D')
        {
            this.status = status;
            return true;
        }
        return false;

     }
}

