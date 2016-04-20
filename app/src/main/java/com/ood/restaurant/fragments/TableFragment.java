package com.ood.restaurant.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.ood.restaurant.R;
import com.ood.restaurant.TableDialog;
import com.ood.restaurant.TableGridViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class TableFragment extends Fragment implements AdapterView.OnItemClickListener {

    // TODO: Use a less hacky way to track tables and TextViews
    public static ArrayList<Boolean> tableList = new ArrayList<>();
    public static HashMap<Integer, TextView> tableViews = new HashMap<>();
    static {
        for (int i = 0; i < 15; i++) {
            tableList.add(false);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_table_list, container, false);
        GridView tableGrid = (GridView) view;

        // Set the adapter
        tableGrid.setAdapter(new TableGridViewAdapter(getActivity(),
                R.layout.fragment_table, tableList));
        tableGrid.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle args = new Bundle();
        args.putInt("table", position);
        TableDialog tableDialog = new TableDialog();
        tableDialog.setArguments(args);
        tableDialog.show(getActivity().getSupportFragmentManager(), "TableDialog");
    }
}
