package com.example.nviller.projetm2psav;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nviller.projetm2psav.Model.Evenement;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateEventActivity extends AppCompatActivity {

    protected EditText eventNameEditText;
    protected Button createEventButton;
    protected DatabaseReference databaseEvent = FirebaseDatabase.getInstance().getReference("events");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        eventNameEditText = (EditText) findViewById(R.id.name_event_cea);
        createEventButton = (Button) findViewById(R.id.create_event_cea);


        createEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String eventName = eventNameEditText.getText().toString().trim();



                if (eventName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Veuillez remplir le nom de l'événement.", Toast.LENGTH_SHORT).show();
                } else{
                    databaseEvent.push()
                            .setValue(new Evenement( "", eventName, eventStart, eventEnd, eventType, eventAssociation, eventLocation,
                                    Float.parseFloat(eventPrice), Integer.parseInt(eventSeatsAvailable), eventDescription)
                                    .toMap());
                    Toast.makeText(getApplicationContext(), "Evenement Créé", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
