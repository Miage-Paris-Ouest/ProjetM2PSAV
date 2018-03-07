package com.example.nviller.projetm2psav.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nviller.projetm2psav.R;

/**
 * Created by mouna on 07/03/2018.
 */

public class SpotifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spotify);

        final Button buttonCreateUser = (Button) findViewById(R.id.activity_spotify_retour);
        buttonCreateUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpotifyActivity.this, GestionEventActivity.class);
                startActivity(intent);
            }

        });
    }

}
