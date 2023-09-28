package com.inventine.model;

public class Image {

    private String id;
    private String content_type;
    private int size;
    private byte[] data;

    public String getId() {
        return id;
    }

    public boolean setId(String id) {
        try{
            this.id = id;
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public String getContentType() {
        return content_type;
    }

    public boolean setContentType(String content_type) {

        try{
            this.content_type = content_type;
            return true;
        } catch(Exception e){
            return false;
        }

    }

    public int getSize() {
        return size;
    }

    public boolean setSize(int size) {

        try{
            this.size = size;
            return true;
        } catch(Exception e){
            return false;
        }

    }

    public byte[] getData() {
        return data;
    }

    public boolean setData(byte[] data) {

        try{
            this.data = data;
            return true;
        } catch(Exception e){
            return false;
        }


    }
}
