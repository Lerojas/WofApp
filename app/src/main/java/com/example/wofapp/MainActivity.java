package com.example.wofapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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

        Search search = new Interceptors().theMostBasicInterceptor();
        search.getListBreeds().enqueue(new Callback<Breed>() {
            @Override
            public void onResponse(Call<Breed> call, Response<Breed> response) {
                //LOG DEBUG
                Log.e("XXXXX","RESPUESTA: " + response);
            }

            @Override
            public void onFailure(Call<Breed> call, Throwable t) {

            }
        });






        ArrayList<Breed> breeds = new ArrayList<>();
        breeds.add(new Breed("raza 1"));
        breeds.add(new Breed("raza 2"));
        breeds.add(new Breed("raza 3"));
        breeds.add(new Breed("raza 4"));

        BreedAdapter breedAdapter = new BreedAdapter(breeds, new BreedAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(breedAdapter);
    }
}
