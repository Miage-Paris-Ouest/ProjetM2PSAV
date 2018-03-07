package com.example.nviller.projetm2psav.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by nviller on 07/03/2018.
 */

public class CustomAdapter extends SimpleAdapter {

    public CustomAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return super.getView(position, convertView, parent);
    }

    @Override
    public void setViewBinder(SimpleAdapter.ViewBinder viewBinder) {
        super.setViewBinder(viewBinder);
    }
}
