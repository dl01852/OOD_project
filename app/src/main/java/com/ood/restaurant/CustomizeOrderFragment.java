package com.ood.restaurant;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ood.restaurant.Data.Burger;
import com.ood.restaurant.Data.Decorator;
import com.ood.restaurant.Data.DummyContent;
import com.ood.restaurant.Data.DummyContent.DummyItem;
import com.ood.restaurant.Data.Food;
import com.ood.restaurant.fragments.CustomizeItemViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CustomizeOrderFragment extends DialogFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters



    private RecyclerView recyclerView;
    private CustomizeItemViewAdapter decoratorAdapter;
    StaticData sData = StaticData.i();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CustomizeOrderFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CustomizeOrderFragment newInstance(int columnCount) {
        CustomizeOrderFragment fragment = new CustomizeOrderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.getDialog().setTitle(getArguments().getString("title"));
        String itemName = getArguments().getString("itemName");
        View layout = inflater.inflate(R.layout.fragment_customizeorder_list, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.customize_list);
        decoratorAdapter = new CustomizeItemViewAdapter(getActivity(),converToMenuItem(itemName));
        recyclerView.setAdapter(decoratorAdapter);
        return layout;
    }

    public List<MenuItemData> converToMenuItem(String itemName)
    {
        List<MenuItemData> data = new ArrayList<>();
        String className = "com.ood.restaurant.Data."+itemName;
        try {
            List<Decorator> getClass = sData.getStuff().get(Class.forName(className.trim()));

            for (Decorator d : getClass) {
                MenuItemData tempData = new MenuItemData();
                tempData.itemName = (String) d.getClass().getMethod("getName", (Class[]) null).invoke(d, (Object[]) null);
                tempData.itemDescription = tempData.itemName;
                tempData.itemPrice = (Double) d.getClass().getMethod("getCost", (Class[]) null).invoke(d, (Object[]) null);
                data.add(tempData);
            }


        }catch (Exception e)
        {
            // Exception...
            e.printStackTrace();
        }

        return data;
    }
    

}
