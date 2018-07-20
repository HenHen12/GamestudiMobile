package skripsigame.skripsi.Fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;



import skripsigame.skripsi.ApiClient.GameService;
import skripsigame.skripsi.Data.GameData;
import skripsigame.skripsi.Model.Games;
import skripsigame.skripsi.R;

public class RekomendasiAdapter extends RecyclerView.Adapter<RekomendasiAdapter.ViewHolder>{
    List<GameData> gameDataList;
    private GameService gameService;
    private Context context;
    public RekomendasiAdapter(List<GameData> items) {
        gameDataList = items;
    }

    @Override
    public RekomendasiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrekomendasi,parent,false);
        context = view.getContext();
        gameService.getGame();
        return new RekomendasiAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RekomendasiAdapter.ViewHolder holder, int position){
        final GameData gameData = this.gameDataList.get(position);
        holder.game_name.setText(gameData.getGame_name());
        holder.harga.setText(gameData.getHarga());
        holder.rating.setText(gameData.getRating());
        holder.release_date.setText(gameData.getRelease_date());
        final String photo_url = gameData.getPhoto_url();
        Glide.with(context).load(photo_url).into(holder.photo);


    }

    @Override
    public int getItemCount(){
        return gameDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView game_name,harga,rating,release_date;
        public ImageView photo;

        public ViewHolder(View view){
            super(view);
            game_name = (TextView) view.findViewById(R.id.judul);
            harga = (TextView) view.findViewById(R.id.harga);
            rating = (TextView) view.findViewById(R.id.rating);
            release_date = (TextView) view.findViewById(R.id.tanggal);
            photo = (ImageView) view.findViewById(R.id.gambar);
        }
        }
    }

