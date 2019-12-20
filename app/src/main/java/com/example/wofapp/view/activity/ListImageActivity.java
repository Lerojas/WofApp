package com.example.wofapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.wofapp.data.entity.Image;
import com.example.wofapp.view.adapter.ImageAdapter;
import com.example.wofapp.data.repository.Interceptors;
import com.example.wofapp.R;
import com.example.wofapp.data.repository.datasource.SearchImage;
import com.example.wofapp.view.viewmodel.WrapperImage;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String nameBreed = bundle.getString("nameBreed","");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        final ArrayList<Image> images = new ArrayList<>();
        final ImageAdapter imageAdapter = new ImageAdapter(images);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(imageAdapter);


        SearchImage searchImage = new Interceptors().theMostBasicInterceptorImage();
        searchImage.getListImage(nameBreed).enqueue(new Callback<WrapperImage>() {
            @Override
            public void onResponse(Call<WrapperImage> call, Response<WrapperImage> response) {

                if(response.body().getStatus().equals("success")){

                    JsonArray jsonArray = response.body().getMessage();

                    for (JsonElement pa : jsonArray) {
                        String urlImage = pa.getAsString();
                        images.add(new Image(urlImage));
                    }

                    imageAdapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(ListImageActivity.this, "Error al obtener los datos de la api", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WrapperImage> call, Throwable t) {
                Toast.makeText(ListImageActivity.this, "Error al conectarse de la api", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
