package com.example.wofapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Search {

    @GET("api/breeds/list")
    Call<Breed> getListBreeds();
}
