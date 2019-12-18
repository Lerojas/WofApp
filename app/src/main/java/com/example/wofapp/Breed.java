package com.example.wofapp;

import com.google.gson.JsonArray;

public class Breed {

    private String nameBreed;
    private JsonArray results;

    public Breed(String nameBreed) {
        this.nameBreed = nameBreed;
    }

    public String getNameBreed() {
        return nameBreed;
    }

    public void setNameBreed(String nameBreed) {
        this.nameBreed = nameBreed;
    }

    public JsonArray getResults() {
        return results;
    }

    public void setResults(JsonArray results) {
        this.results = results;
    }
}
