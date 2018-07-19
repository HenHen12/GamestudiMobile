package skripsigame.skripsi.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import skripsigame.skripsi.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NewGame.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NewGame#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewGame extends Fragment {
    String[] strings = {"1", "2", "3", "4", "5"};

    public NewGame() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new NewGameAdapter(strings));
        return rv;
    }
    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public TextView harga;
        public SimpleViewHolder(View itemView){
            super(itemView);
            harga = (TextView) itemView.findViewById(R.id.harga);
        }
    }
}
