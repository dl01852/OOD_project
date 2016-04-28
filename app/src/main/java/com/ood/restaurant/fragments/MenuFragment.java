package com.ood.restaurant.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ood.restaurant.Listeners;
import com.ood.restaurant.MenuItemData;
import com.ood.restaurant.adapters.MenuItemViewAdapter;
import com.ood.restaurant.R;
import com.ood.restaurant.StaticData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david-lewis on 4/5/2016.
 */
public class MenuFragment extends Fragment implements Listeners.OnCustomizeListener {

    public static CustomizeOrderFragment customizeOrderFragment;
    static StaticData staticData = StaticData.i(); // grab an instance of the data.

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.add_order, container, false);
        // Initialize recycler view
        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.menu_List);

        // Create menu adapter and assign it to the recycler view
        MenuItemViewAdapter menuAdapter = new MenuItemViewAdapter(getActivity(), getMenuData(), this);
        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Create the toolbar
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Set the on click listener for the back button
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_layout,new TableFragment())
                        .commit();
            }
        });

        return layout;
    }

    /**
     * Get the menu data for the adapter
     * @return List of MenuItemData elements
     */
    public static List<MenuItemData> getMenuData() {
        List<Class> menu = staticData.getMenu();
        List<MenuItemData> data = new ArrayList<>();

        try {
            for (Class food : menu) {
                MenuItemData tempData = new MenuItemData();

                // Invoke the cost() method of the Food item and save the result
                double cost = (Double) food.getMethod("cost", (Class[]) null)
                        .invoke(food.newInstance(), (Object[]) null);
                // Invoke the getDescription() method of the Food item and save the result
                String name = food.getMethod("getDescription", (Class[]) null)
                        .invoke(food.newInstance(), (Object[]) null).toString();
                tempData.itemDescription = name;
                tempData.itemName = name.trim();
                tempData.itemPrice = cost;
                // Add item to the list
                data.add(tempData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Event triggered when the "Customize" button is clicked
     * @param itemName Item to be customized
     */
    @Override
    public void onCustomizeClicked(String itemName) {
        // Create customize order dialog
        customizeOrderFragment = new CustomizeOrderFragment();

        // Set arguments
        Bundle args = new Bundle();
        args.putString("itemName",itemName);
        args.putString("title",itemName);
        customizeOrderFragment.setArguments(args);

        // Start the dialog
        customizeOrderFragment.show(getActivity().getSupportFragmentManager(), "Dialog");
    }

}
