package com.example.wofapp.data.repository;

import com.example.wofapp.data.repository.datasource.SearchBreed;
import com.example.wofapp.data.repository.datasource.SearchImage;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Interceptors {

    private static final String BASE_URL = "https://dog.ceo/";

    public SearchBreed theMostBasicInterceptor() {
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                /*Never forget about adding the converter, otherwise you can not parse the data*/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SearchBreed someRequest = interceptor.create(SearchBreed.class);
        /*The interceptor must return an interface, is the same interface where you wrote the methods for the request http*/
        return someRequest;
    }

    public SearchImage theMostBasicInterceptorImage() {
        Retrofit interceptor = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                /*Never forget about adding the converter, otherwise you can not parse the data*/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SearchImage someRequest = interceptor.create(SearchImage.class);
        /*The interceptor must return an interface, is the same interface where you wrote the methods for the request http*/
        return someRequest;
    }
}
