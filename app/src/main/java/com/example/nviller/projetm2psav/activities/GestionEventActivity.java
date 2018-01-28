package com.example.nviller.projetm2psav.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nviller.projetm2psav.R;
import com.example.nviller.projetm2psav.dao.DAOUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by mouna on 28/01/2018.
 */

public class GestionEventActivity extends AppCompatActivity{

    private DAOUser daoUser;
    protected DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_event);

        this.daoUser = DAOUser.getInstance();

        if(!daoUser.isLoggedIn()){
            redirectIfNotLoggedIn();
        }
        else{
            Button logoutButton = (Button) findViewById(R.id.activity_gestion_event_log_out);
            logoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    logOut();
                }
            });
        }

    }

    protected void redirectIfNotLoggedIn() {
        if (!daoUser.isLoggedIn())
            loadLogInView();
    }

    protected void loadLogInView() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    protected void logOut() {
        daoUser.signOut();
        finish();
        startActivity(getIntent());
    }

}
