package com.inventine.model;

import com.inventine.util.DataValidator;

import java.sql.Timestamp;

public class Meeting {
        private String meetingId;
        private String creatorId;
        private Timestamp createdAt;
        private Timestamp launchedAt;
        private String link;
        private String description;
        private char status;
        private DataValidator validator = new DataValidator();

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

        public Timestamp getCreatedAt(){ return createdAt;}

        public boolean setCreatedAt(Timestamp createdAt){
            try{
                this.createdAt = createdAt;

            }catch (Exception e){
                return true;
            }

            return false;
        }

        public Timestamp getLaunchedAt(){ return launchedAt;}

        public boolean setLaunchedAt(Timestamp launchedAt){
            try{
                this.launchedAt = launchedAt;

            }catch (Exception e){
                return true;
            }

            return false;
        }

        public String getLink(){ return link;}

        public boolean setLink(String link){
            this.validator.setTxt(link);
            this.validator.setMinLength(8);
            this.validator.setMaxLength(255);

            if (this.validator.isAlphaNumeric()) {
                this.link = link;
                return true;
            }

            return false;
        }


        public char getStatus(){ return status;}

        public boolean setStatus(char status){

            if (status == 'A' || status == 'R' || status == 'D') {
                this.status = status;
                return true;
            }

            return false;
        }

        public String getDescription(){ return description;}

        public boolean setDescription(String description){

            this.description=description;
            return true;
        }


}

