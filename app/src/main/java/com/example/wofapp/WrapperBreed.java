package com.example.wofapp;

import com.google.gson.JsonArray;

public class WrapperBreed {

    private JsonArray message;
    private String status;

    public WrapperBreed(JsonArray message, String status) {
        this.message = message;
        this.status = status;
    }

    public JsonArray getMessage() {
        return message;
    }

    public void setMessage(JsonArray message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
