package skripsigame.skripsi.Fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import skripsigame.skripsi.R;

public class NewGameAdapter extends RecyclerView.Adapter<NewGame.SimpleViewHolder>{
    private String[] dataSource;
    public NewGameAdapter(String[] dataArgs){
        dataSource = dataArgs;
    }

    @Override
    public NewGame.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrekomendasi, parent, false);
        NewGame.SimpleViewHolder ViewHolder = new NewGame.SimpleViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(NewGame.SimpleViewHolder holder, int position){
        holder.harga.setText(dataSource[position]);
    }

    @Override
    public int getItemCount(){
        return dataSource.length;
    }

}