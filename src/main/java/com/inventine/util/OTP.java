package com.inventine.util;


public class OTP {

    public static String generateOTP()
    {

        int randomPin =(int) (Math.random()*9000)+1000;
        String otp = String.valueOf(randomPin);
        return otp;
    }
}

