package com.inventine.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter {

    public Timestamp stringToTimestamp(String ts){

        Timestamp timestamp = null;

        try {
            ts = ts.concat(".0");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
            Date parsedDate = dateFormat.parse(ts);
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch(Exception e) { //this generic but you can control another types of exception
            e.printStackTrace();
        }

        return timestamp;
    }
}
