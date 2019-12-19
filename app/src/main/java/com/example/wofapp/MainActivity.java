package com.example.wofapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final ArrayList<Breed> breeds = new ArrayList<>();

        final BreedAdapter breedAdapter = new BreedAdapter(breeds, new BreedAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("nameBreed",breeds.get(position).getName());
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(breedAdapter);

        Search search = new Interceptors().theMostBasicInterceptor();
        search.getListBreeds().enqueue(new Callback<WrapperBreed>() {
            @Override
            public void onResponse(Call<WrapperBreed> call, Response<WrapperBreed> response) {

                //LOG DEBUG
                //Log.e("XXXXX","RESPUESTA: " + response.body().getMessage());
                //Log.e("XXXXX","RESPUESTA: " + response.body().getStatus());

                if(response.body().getStatus().equals("success")){

                    JsonArray jsonArray = response.body().getMessage();

                    for (JsonElement pa : jsonArray) {

                        String name = pa.getAsString();
                        //Log.e("XXXXX","name: " + name);
                        breeds.add(new Breed(name));
                    }

                    breedAdapter.notifyDataSetChanged();
                }
                else{
                    //TODO: MOSTRAR MENSAJE DE FAILED DE CONECCION A LA API.
                }
            }

            @Override
            public void onFailure(Call<WrapperBreed> call, Throwable t) {
                //TODO: MOSTRAR MENSAJE DE FAILED DE CONECCION A LA API.
            }
        });
    }
}
