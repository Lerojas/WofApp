package com.example.wofapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wofapp.data.entity.Image;
import com.example.wofapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    private ArrayList<Image> images;

    public ImageAdapter(ArrayList<Image> images) {
        this.images = images;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageIv;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageIv = itemView.findViewById(R.id.imageIv);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_image_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(images.get(position).getUrlImage()).into(holder.imageIv);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}
