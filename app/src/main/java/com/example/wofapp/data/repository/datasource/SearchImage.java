package com.example.wofapp.data.repository.datasource;

import com.example.wofapp.view.viewmodel.WrapperImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SearchImage {

    @GET("api/breed/{nameBreed}/images")
    Call<WrapperImage> getListImage(@Path("nameBreed") String nameBreed);
}
