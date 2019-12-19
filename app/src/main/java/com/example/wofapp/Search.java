package com.example.wofapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Search {

    @GET("api/breeds/list")
    Call<WrapperBreed> getListBreeds();
}
