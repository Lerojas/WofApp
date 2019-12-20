package com.example.wofapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wofapp.data.entity.Breed;
import com.example.wofapp.R;

import java.util.ArrayList;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<Breed> breeds;
    private OnItemClickListener listener;

    public BreedAdapter(ArrayList<Breed> breeds, OnItemClickListener listener) {
        this.breeds = breeds;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nameBreedTv;

        public MyViewHolder(View itemView) {
            super(itemView);

            nameBreedTv = itemView.findViewById(R.id.nameBreedTv);
        }

        public void bind(final BreedAdapter.OnItemClickListener listener){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameBreedTv.setText(breeds.get(position).getName());
        holder.bind(listener);

        if (position%2!=0){
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorStripped));
        }else{
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }
    }

    @Override
    public int getItemCount() {
        return breeds.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
