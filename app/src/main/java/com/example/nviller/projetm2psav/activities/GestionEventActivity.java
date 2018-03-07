package com.example.nviller.projetm2psav.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.nviller.projetm2psav.R;
import com.example.nviller.projetm2psav.dao.DAOUser;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by mouna on 28/01/2018.
 */

public class GestionEventActivity extends AppCompatActivity{

    private DAOUser daoUser;
    protected DatabaseReference database = FirebaseDatabase.getInstance().getReference("users");
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* API Facebook */


        //FacebookSdk.sdkInitialize(getApplicationContext());
        //AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_gestion_event);

        callbackManager = CallbackManager.Factory.create();

        final Button buttonEventProx = (Button) findViewById(R.id.activity_gestion_event_proximite);
        buttonEventProx.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionEventActivity.this, EventNearbyActivity.class);
                startActivity(intent);
            }

        });

        final LoginButton buttonEventFacebook = (LoginButton) findViewById(R.id.activity_gestion_event_facebook);
        buttonEventFacebook.setReadPermissions("email","public_profile","user_events");
        // Callback registration
        buttonEventFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Intent intentfb = new Intent(GestionEventActivity.this, LogFacebookActivity.class);
                System.out.println("MON LOGIN : "+loginResult);
                intentfb.putExtra("token",loginResult.getAccessToken().toString());
                startActivity(intentfb);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        final Button buttonEventSpotify = (Button) findViewById(R.id.activity_gestion_event_spotify);
        buttonEventSpotify.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionEventActivity.this, SpotifyActivity.class);
                startActivity(intent);
            }

        });

        final Button buttonCreateEvent = (Button) findViewById(R.id.activity_gestion_event_creer);
        buttonCreateEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestionEventActivity.this, CreateEventActivity.class);
                startActivity(intent);
            }

        });

        Button logoutButton = (Button) findViewById(R.id.activity_gestion_event_log_out);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
