package com.nnte.primeiraaula_diceapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Integer> dataList;

    public MyAdapter(List<Integer> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Integer data = dataList.get(position);
        holder.imageViewItem.setImageResource(data);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewItem;
        ImageView imageViewItem;

        public ViewHolder(View itemView) {
            super(itemView);
            //textViewItem = itemView.findViewById(R.id.textViewItem);
            imageViewItem = itemView.findViewById(R.id.imageViewItem);
        }
    }
}
