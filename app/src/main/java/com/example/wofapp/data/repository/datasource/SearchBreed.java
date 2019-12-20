package com.example.wofapp.data.repository.datasource;

import com.example.wofapp.view.viewmodel.WrapperBreed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SearchBreed {

    @GET("api/breeds/list")
    Call<WrapperBreed> getListBreeds();
}

