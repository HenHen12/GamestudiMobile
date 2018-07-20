package skripsigame.skripsi.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import skripsigame.skripsi.ApiClient.GameService;
import skripsigame.skripsi.Data.GameData;
import skripsigame.skripsi.Model.Games;
import skripsigame.skripsi.R;


public class Rekomendasi extends Fragment {
    private RecyclerView recyclerView;
    private RekomendasiAdapter rekomendasiAdapter;
    private GameService gameService;
    private static List<GameData> gameData;
    AlertDialog alertDialog;
    AlertDialog.Builder alertDialogBuilder;


    public Rekomendasi() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameData = new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rekomendasi, container,false);
        gameData = new ArrayList<>();

        recyclerView = view.findViewById(R.id.RekomendasiRV);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
//        showList();
        return view;
    }

    private void showList(){
        gameService.getGame()
                .enqueue(new Callback<List<GameData>>() {
                    @Override
                    public void onResponse(Call<List<GameData>> call, Response<List<GameData>> response) {
                        if(response.isSuccessful()){
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().toString());
                                if (jsonRESULTS.getString("error").equals("false")){
                                    Integer n = jsonRESULTS.length() - 1;

                                    gameData  = new ArrayList<GameData>();

                                    //generate list
                                    for (int I = 0; I<n; I++) {
                                        String game_name = jsonRESULTS.getJSONObject(""+I).getString("game_name");
                                        String release_date = jsonRESULTS.getJSONObject(""+I).getString("release_date");
                                        String harga = jsonRESULTS.getJSONObject(""+I).getString("harga");
                                        String id = jsonRESULTS.getJSONObject(""+I).getString("id");
                                        String rating = jsonRESULTS.getJSONObject(""+I).getString("rating");
                                        String photo_url = jsonRESULTS.getJSONObject(""+I).getString("photo_url");

                                        // adding each child node to ArrayList key =&gt; value
                                        gameData.add(new GameData(game_name,release_date, harga, id, rating,photo_url ));
                                    }

                                    //instantiate custom adapter
                                    rekomendasiAdapter = new RekomendasiAdapter(gameData);

                                    //handle listview and assign adapter
                                    recyclerView.setAdapter(rekomendasiAdapter);
                                } else {
                                    // Jika login gagal
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(getContext(), error_message, Toast.LENGTH_SHORT).show();
                                }
                            }catch (JSONException e) {
                                Toast.makeText(getContext(),"Koneksi Gagal, periksa koneksi internet",Toast.LENGTH_LONG);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<GameData>> call, Throwable t) {
                        Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                        alertDialogBuilder.setMessage("Jaringan Sedang Bermasalah").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                });
    }


}
