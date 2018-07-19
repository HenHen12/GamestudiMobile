package skripsigame.skripsi.Fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import skripsigame.skripsi.R;

public class PopularAdapter extends RecyclerView.Adapter<Popular.SimpleViewHolder>{
    private String[] dataSource;
    public PopularAdapter(String[] dataArgs){
        dataSource = dataArgs;
    }

    @Override
    public Popular.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrekomendasi, parent, false);
        Popular.SimpleViewHolder ViewHolder = new Popular.SimpleViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(Popular.SimpleViewHolder holder, int position){
        holder.tanggal.setText(dataSource[position]);
    }

    @Override
    public int getItemCount(){
        return dataSource.length;
    }

}