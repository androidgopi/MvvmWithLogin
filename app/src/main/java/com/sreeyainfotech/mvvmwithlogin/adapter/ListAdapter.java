package com.sreeyainfotech.mvvmwithlogin.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sreeyainfotech.mvvmwithlogin.R;
import com.sreeyainfotech.mvvmwithlogin.model.LoadDetails;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter  extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    List<LoadDetails> loadDetailsList=new ArrayList<>();

    public ListAdapter(List<LoadDetails> moviesList) {
        this.loadDetailsList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LoadDetails loadDetails = loadDetailsList.get(position);
        holder.title.setText(loadDetails.getLoadTrackingNumber());
        holder.genre.setText(loadDetails.getStatus());
        holder.year.setText(loadDetails.getLoadId());
    }

    @Override
    public int getItemCount() {
        return loadDetailsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(@NonNull View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }

}
