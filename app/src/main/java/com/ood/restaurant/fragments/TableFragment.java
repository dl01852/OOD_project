package com.ood.restaurant.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ood.restaurant.R;
import com.ood.restaurant.StaticData;
import com.ood.restaurant.TableDialog;
import com.ood.restaurant.TableGridViewAdapter;

public class TableFragment extends Fragment implements AdapterView.OnItemClickListener {

    public static GridView tableGrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.fragment_table_list, container, false);
        tableGrid = (GridView) view;

        // Set the adapter
        tableGrid.setAdapter(new TableGridViewAdapter(getActivity(),
                R.layout.fragment_table, StaticData.i().tables()));
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
