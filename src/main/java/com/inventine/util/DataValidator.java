package com.inventine.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    private String txt;
    private int minLength = 1;
    private int maxLength = 100;

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isMatch(String PATTERN){
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher match = pattern.matcher(this.txt);
        return match.matches();
    }

    public boolean isBasic(String PATTERN){
        PATTERN = String.format("%s{%d,%d}$",PATTERN,getMinLength(),getMaxLength());
        return isMatch(PATTERN);
    }

    public boolean isSmall(){

        return isBasic("^[a-z]");
    }

    public boolean isCapital(){

        return isBasic("^[A-Z]");
    }

    public boolean isString(){

        return isBasic("^[a-zA-Z]");
    }

    public boolean isNumber(){

        return isBasic("^[0-9]");
    }

    public boolean isAlphaNumeric(){

        return isBasic("^[a-zA-Z0-9]");

    }

    public boolean isEmail(){
        String PATTERN = String.format("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}");
        return isMatch(PATTERN);

    }

    public boolean isPhone(){

        String PATTERN = String.format("^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$");
        return isMatch(PATTERN);

    }

    public boolean isAddress(){

        String PATTERN = String.format("^[a-zA-Z 0-9\\.\\,\\/\\-]{10,255}");
        return isMatch(PATTERN);

    }


    public boolean isSHA256(){

        return isMatch("\\b[A-Fa-f0-9]{64}\\b");
    }

}
