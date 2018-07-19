package skripsigame.skripsi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import skripsigame.skripsi.R;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button updateprofile = (Button)findViewById(R.id.updateprofile);
        updateprofile.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),UpdateProfile.class);
                startActivity(i);
            }
        }));

        Button updatespecification = (Button)findViewById(R.id.updatespecification);
        updatespecification.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),UpdateSpecification.class);
                startActivity(i);
            }
        }));
    }
}
