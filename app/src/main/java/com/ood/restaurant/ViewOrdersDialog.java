package com.ood.restaurant;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ood.restaurant.adapters.ViewOrdersAdapter;

/**
 * View Orders Dialog
 * @author Michael Palmer
 */
public class ViewOrdersDialog extends DialogFragment {

    /**
     * Initialize the view
     * @param inflater Layout Inflater
     * @param container View group container
     * @param savedInstanceState Bundle saved instance state
     * @return Created view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the dialog
        View rootView = inflater.inflate(R.layout.dialog_view_orders_list, container, false);

        // Get arguments passed in (table number) and set the title
        int table = getArguments().getInt("table");
        super.getDialog().setTitle(getString(R.string.tableN, table + 1));

        // Setup RecyclerView
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.order_list);

        // Create the adapter
        ViewOrdersAdapter adapter = new ViewOrdersAdapter(getActivity(),
                MainActivity.myDB.getOrders(table));
        recyclerView.setAdapter(adapter);

        // Set layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Return the view
        return rootView;
    }
}
