package skripsigame.skripsi.Fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import skripsigame.skripsi.R;

public class RekomendasiAdapter extends RecyclerView.Adapter<Rekomendasi.SimpleViewHolder>{
    private String[] dataSource;
    public RekomendasiAdapter(String[] dataArgs){
        dataSource = dataArgs;
    }

    @Override
    public Rekomendasi.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrekomendasi, parent, false);
        Rekomendasi.SimpleViewHolder ViewHolder = new Rekomendasi.SimpleViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(Rekomendasi.SimpleViewHolder holder, int position){
        holder.judul.setText(dataSource[position]);
    }

    @Override
    public int getItemCount(){
        return dataSource.length;
    }

}