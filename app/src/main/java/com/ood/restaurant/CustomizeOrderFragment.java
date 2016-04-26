package com.ood.restaurant;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.ood.restaurant.Data.Burger;
import com.ood.restaurant.Data.Decorator;
import com.ood.restaurant.Data.DummyContent;
import com.ood.restaurant.Data.DummyContent.DummyItem;
import com.ood.restaurant.Data.Food;
import com.ood.restaurant.fragments.CustomizeItemViewAdapter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class CustomizeOrderFragment extends DialogFragment implements Listeners.OnCustomizeAddListener, View.OnClickListener {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters



    private RecyclerView recyclerView;
    String itemName;
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
        itemName = getArguments().getString("itemName"); // Food Name
        View layout = inflater.inflate(R.layout.fragment_customizeorder_list, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.customize_list);
        decoratorAdapter = new CustomizeItemViewAdapter(getActivity(),converToMenuItem(itemName),this);
        recyclerView.setAdapter(decoratorAdapter);
        Button button = (Button) layout.findViewById(R.id.btn_save_order);
        button.setOnClickListener(this);
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


    @Override
    public void onCustomizeClicked(String decoratorName) {

        Toast.makeText(getContext(),decoratorName,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        Map<String, Boolean> toppings = new HashMap<>();

        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            CardView card = (CardView) ((LinearLayout) recyclerView.getChildAt(i)).getChildAt(0);
            RelativeLayout layout = (RelativeLayout) card.getChildAt(0);
            CheckBox check = (CheckBox) layout.getChildAt(2);
            TextView topping = (TextView) layout.getChildAt(0);
            toppings.put(topping.getText().toString(),check.isChecked());
        }

        if(itemName.equals("Burger"))
        {
            Food burger = new Burger();
            for(Map.Entry<String,Boolean> entry : toppings.entrySet())
            {
                String topping = entry.getKey();
                Boolean add = entry.getValue();

                if(add)
                {
                    try
                    {
                        Class<?> decorator = Class.forName("com.ood.restaurant.Data."+topping);
                        Constructor<?> ctor = decorator.getConstructor(Food.class);
                        burger = (Food) ctor.newInstance(new Food[]{burger});
                    }catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | java.lang.InstantiationException e)
                    {
                        // Error
                        e.printStackTrace();
                    }
                }
            }
            String title = burger.getDescription();
            Toast.makeText(getContext(),title,Toast.LENGTH_LONG).show();
        }
    }
}
