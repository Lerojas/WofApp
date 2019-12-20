package com.example.wofapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.wofapp.data.entity.Breed;
import com.example.wofapp.view.adapter.BreedAdapter;
import com.example.wofapp.data.repository.Interceptors;
import com.example.wofapp.R;
import com.example.wofapp.data.repository.datasource.SearchBreed;
import com.example.wofapp.view.viewmodel.WrapperBreed;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBreedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final ArrayList<Breed> breeds = new ArrayList<>();

        final BreedAdapter breedAdapter = new BreedAdapter(breeds, new BreedAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(ListBreedActivity.this, ListImageActivity.class);
                intent.putExtra("nameBreed",breeds.get(position).getName());
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(breedAdapter);

        SearchBreed searchBreed = new Interceptors().theMostBasicInterceptor();
        searchBreed.getListBreeds().enqueue(new Callback<WrapperBreed>() {
            @Override
            public void onResponse(Call<WrapperBreed> call, Response<WrapperBreed> response) {

                if(response.body().getStatus().equals("success")){

                    JsonArray jsonArray = response.body().getMessage();

                    for (JsonElement pa : jsonArray) {
                        String name = pa.getAsString();
                        breeds.add(new Breed(name));
                    }

                    breedAdapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(ListBreedActivity.this, "Error al obtener los datos de la api", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WrapperBreed> call, Throwable t) {
                Toast.makeText(ListBreedActivity.this, "Error al conectarse de la api", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
