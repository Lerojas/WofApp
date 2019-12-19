package com.example.wofapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String nameBreed = bundle.getString("nameBreed","");

        ImageView imageView = findViewById(R.id.image);
        Log.e("XXXXX","RESPUESTA: " + nameBreed);


        String urlImage = "https://dog.ceo/api/breed/" + nameBreed + "/images";
        Log.e("XXXXX","URL IMAGEN: " + urlImage);

        Picasso.get().load(urlImage).into(imageView);
    }
}
