package com.ood.restaurant.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ood.restaurant.Data.Food;
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
public class MenuFragment extends Fragment {

    private RecyclerView recyclerView;
    private MenuItemViewAdapter menuAdapter;
    static StaticData staticData = StaticData.i(); // grab an instance of the data.

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View layout = inflater.inflate(R.layout.add_order, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.menu_List);
        menuAdapter = new MenuItemViewAdapter(getActivity(),getMenuData());
        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return layout;
    }

    public static List<MenuItemData> getMenuData()
    {
        // this needs to contain the REAL data for each Menu item... For now, i'm using Test data.
        List<Class> menu = staticData.getMenu();
        List<MenuItemData> data = new ArrayList<>();
//        // Test data
//        String[] itemNames = {"item 1", "item 2", "item 3", "item 4"};
//        Double[] itemPrices = {5.99, 6.99, 7.99, 8.99};
//        String[] itemDescriptions = {"description 1", "description 2", "description 3", "description 4"};
        try {
        for(Class food: menu)
        {
            MenuItemData tempData = new MenuItemData();

//                Object getDescription = food.getMethod("getDescription", null).invoke(null, null);
                Method[] methods = food.getMethods();
                double x = (Double) food.getMethod("cost", (Class[]) null).invoke(food.newInstance(), (Object[]) null);
                for(Method method : methods)
                {
                    if(method.getName().equals("getDescription"))
                    {
                        tempData.itemDescription = (String) method.invoke(food.newInstance(), (Object[]) null);
                        tempData.itemName = tempData.itemDescription;
                    }
                    else if(method.getName().equals("cost"))
                    {
                        tempData.itemPrice = (double)method.invoke(food.newInstance(), (Object[]) null);
                    }
                }
                data.add(tempData);
//
//                tempData.itemDescription = getDescription.toString();
//                tempData.itemPrice = food.cost();
//                tempData.itemName = food.getDescription(); // same as itemDescription... This should change but fuck it for now


        }
        }catch (Exception e)
        {
            e.printStackTrace();
            // err...
        }
        // load test Data into the ArrayList
//        for(int i = 0; i < itemNames.length; i++)
//        {
//            // create a temp MenuItem and populate the data.
//            MenuItemData tempData = new MenuItemData();
//            tempData.itemName = itemNames[i];
//            tempData.itemPrice = itemPrices[i];
//            tempData.itemDescription = itemDescriptions[i];
//
//            // add the temp item to the array list.
//            data.add(tempData);
//        }

        return data;
    }
}

