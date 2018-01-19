package com.example.nviller.projetm2psav.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nviller.projetm2psav.R;
import com.example.nviller.projetm2psav.model.User;

/**
 * Created by nviller on 19/01/2018.
 */

public class CreateUserActivity extends Activity {

    private EditText emailUser;
    private EditText mdpUser;
    private EditText loginUser;
    private EditText firstnameUser;
    private EditText lastnameUser;
    private User newUser;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        emailUser = (EditText) findViewById(R.id.cu_email_user);
        mdpUser = (EditText) findViewById(R.id.cu_password_user);
        loginUser = (EditText) findViewById(R.id.cu_login_user);
        firstnameUser = (EditText) findViewById(R.id.cu_firstname_user);
        lastnameUser = (EditText) findViewById(R.id.cu_lastname_user);

        final Button buttonCreateUser = (Button) findViewById(R.id.cu_create_user);
        buttonCreateUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                newUser = new User(emailUser.getText().toString(),mdpUser.getText().toString(),loginUser.getText().toString(),firstnameUser.getText().toString(),lastnameUser.getText().toString());
                System.out.println(newUser.getEmailUser());

               
            }

        });

    }
}
