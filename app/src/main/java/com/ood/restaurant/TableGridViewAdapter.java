package com.ood.restaurant;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ood.restaurant.fragments.TableFragment;

import java.util.ArrayList;

public class TableGridViewAdapter extends ArrayAdapter<Boolean> {
    private Context context;
    private int resource;
    private ArrayList<Boolean> tables;

    public TableGridViewAdapter(Context context, int resource, ArrayList<Boolean> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.tables = objects;
    }

    @Override
    public int getCount() {
        return this.tables.size();
    }

    @Override
    public Boolean getItem(int position) {
        return this.tables.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        if (convertView == null) {
            view = inflater.inflate(resource, parent, false);
        } else {
            view = convertView;
        }

        TextView text = (TextView) view;
        text.setText(String.format("%d", position + 1));
        if (!TableFragment.tableViews.containsKey(position)) {
            TableFragment.tableViews.put(position, text);
        }

        // Set table as available
        if (!getItem(position)) {
            text.setBackgroundColor(Color.GREEN);
        }

        return view;
    }
}
