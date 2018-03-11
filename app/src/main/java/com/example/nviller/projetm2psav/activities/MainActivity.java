package com.example.nviller.projetm2psav.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nviller.projetm2psav.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by mouna on 30/01/2018.
 */

public class MainActivity extends AppCompatActivity {


    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        final Button buttonCreateUser = (Button) findViewById(R.id.activity_main_create_button);
        buttonCreateUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateUserActivity.class);
                startActivity(intent);
            }

        });

        final Button buttonLogIn = (Button) findViewById(R.id.activity_main_login_button);
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLog = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentLog);
            }
        });

        final TextView textViewPasCompte = findViewById(R.id.activity_main_not_compte);
        textViewPasCompte.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestionEventActivity.class);
                startActivity(intent);
            }

        });
    }
}
