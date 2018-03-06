package com.example.nviller.projetm2psav.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.nviller.projetm2psav.R;
import com.example.nviller.projetm2psav.model.Event;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by mouna on 01/03/2018.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    public EventAdapter(Context context, ArrayList<Event> events) {
            super(context, R.layout.item_event_list, events);
    }

    private static class ViewHolder {

        private TextView eventName;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Event event = getItem(position);
        View view = convertView;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_event_list, parent, false);
        }

        final View view2 = view;

        final ViewHolder viewHolder = new ViewHolder();

        viewHolder.eventName = (TextView) view.findViewById(R.id.item_event_list_name);
        //viewHolder.assoPicture = (ImageView) view.findViewById(R.id.item_event_listview_event_picture);

        viewHolder.eventName.setText(event.nameEvent);

        FirebaseDatabase.getInstance().getReference("event")
                .child(event.nameEvent)
                .addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.d("onCancelled", databaseError.getMessage());
                    }
                });

        return view;
    }
}
