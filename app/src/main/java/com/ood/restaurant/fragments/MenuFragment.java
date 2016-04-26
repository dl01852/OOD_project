package com.ood.restaurant.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ood.restaurant.CustomizeOrderFragment;
import com.ood.restaurant.Data.Food;
import com.ood.restaurant.Listeners;
import com.ood.restaurant.MenuItemData;
import com.ood.restaurant.MenuItemViewAdapter;
import com.ood.restaurant.R;
import com.ood.restaurant.StaticData;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by david-lewis on 4/5/2016.
 */
public class MenuFragment extends Fragment implements Listeners.OnCustomizeListener {

    private RecyclerView recyclerView;
    private MenuItemViewAdapter menuAdapter;
    public static CustomizeOrderFragment customizeOrderFragment;
    static StaticData staticData = StaticData.i(); // grab an instance of the data.

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.add_order, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.menu_List);
        menuAdapter = new MenuItemViewAdapter(getActivity(), getMenuData(), this);
        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }

    public static List<MenuItemData> getMenuData() {
        List<Class> menu = staticData.getMenu();
        List<MenuItemData> data = new ArrayList<>();

        try {
            for (Class food : menu) {
                MenuItemData tempData = new MenuItemData();

//                Object getDescription = food.getMethod("getDescription", null).invoke(null, null);
                double cost = (Double) food.getMethod("cost", (Class[]) null).invoke(food.newInstance(), (Object[]) null);
                String name = food.getMethod("getDescription", (Class[]) null).invoke(food.newInstance(), (Object[]) null).toString();
                tempData.itemDescription = name;
                tempData.itemName = name.trim();
                tempData.itemPrice = cost;


                data.add(tempData);


            }
        } catch (Exception e) {
            e.printStackTrace();
            // err...
        }


        return data;
    }

    @Override
    public void onCustomizeClicked(String itemName) { // or maybe args.Put()??
//        getActivity()
//                .getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.fragment_layout, new CustomizeOrderFragment())
//                .addToBackStack("CustomizeOrderFragment")
//                .commit();

        Bundle args = new Bundle();
//        args.putInt("room_number", room_number);
//        args.putString("date_from", date_from);
//        args.putString("date_to", date_to);
        args.putString("itemName",itemName);
        args.putString("title",itemName);
        customizeOrderFragment = new CustomizeOrderFragment();
        customizeOrderFragment.setArguments(args);
        customizeOrderFragment.show(getActivity().getSupportFragmentManager(), "Dialog");
    }

    @Override
    public void onOrderClicked() {

    }
}
