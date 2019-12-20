package com.example.wofapp.data.repository.datasource;

import com.example.wofapp.data.repository.Interceptors;
import com.example.wofapp.view.viewmodel.WrapperImage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SearchImageTest {

    @Mock SearchImage searchImage;
    @Mock private String nameBreed;

    @Before
    public void setUp() throws Exception{
        searchImage = new Interceptors().theMostBasicInterceptorImage();
        nameBreed = "doberman";
    }

    @Test
    public void shouldResponseFailed() throws Exception{

        searchImage.getListImage(nameBreed).enqueue(new Callback<WrapperImage>() {
            @Override
            public void onResponse(Call<WrapperImage> call, Response<WrapperImage> response) {
                verify(response.body().getStatus().equalsIgnoreCase("success"));
            }

            @Override
            public void onFailure(Call<WrapperImage> call, Throwable t) {

            }
        });

    }


}