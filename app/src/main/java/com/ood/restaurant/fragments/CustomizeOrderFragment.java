package com.ood.restaurant.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.ood.restaurant.Data.Decorator;
import com.ood.restaurant.Data.Food;
import com.ood.restaurant.MainActivity;
import com.ood.restaurant.MenuItemData;
import com.ood.restaurant.Order;
import com.ood.restaurant.R;
import com.ood.restaurant.StaticData;
import com.ood.restaurant.commands.AddOrderCommand;
import com.ood.restaurant.adapters.CustomizeItemViewAdapter;
import com.ood.restaurant.fragments.MenuFragment;
import com.ood.restaurant.orderDatabase;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CustomizeOrderFragment extends DialogFragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    String itemName;
    StaticData sData = StaticData.i();
    orderDatabase myDB = MainActivity.myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.getDialog().setTitle(getArguments().getString("title")); // same as FoodName.
        itemName = getArguments().getString("itemName"); // Food Name
        View layout = inflater.inflate(R.layout.fragment_customizeorder_list, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.customize_list);
        CustomizeItemViewAdapter decoratorAdapter = new CustomizeItemViewAdapter(getActivity(),
                converToMenuItem(itemName));
        recyclerView.setAdapter(decoratorAdapter);
        Button button = (Button) layout.findViewById(R.id.btn_save_order);
        button.setOnClickListener(this);
        return layout;
    }

    // grabs all Decorators for a particular Food item and and converts them to MenuItemData objects to display to the gui
    public List<MenuItemData> converToMenuItem(String itemName) {
        List<MenuItemData> data = new ArrayList<>();
        String className = "com.ood.restaurant.Data." + itemName;
        try {
            List<Decorator> getClass = sData.getStuff().get(Class.forName(className.trim()));

            for (Decorator d : getClass) {
                MenuItemData tempData = new MenuItemData();
                tempData.itemName = (String) d.getClass().getMethod("getName", (Class[]) null)
                        .invoke(d, (Object[]) null);
                tempData.itemDescription = (String) d.getClass().getMethod("getDecoratorDescription", (Class[]) null)
                        .invoke(d, (Object[]) null);
                tempData.itemPrice = (Double) d.getClass().getMethod("getCost", (Class[]) null)
                        .invoke(d, (Object[]) null);
                data.add(tempData);
            }

        } catch (Exception e) {
            // Exception...
            e.printStackTrace();
        }

        return data;
    }

    @Override
    public void onClick(View v) {
        try {
            Map<String, Boolean> toppings = new HashMap<>();

            // places all the decorators Name and whether or not if it is checked or not into a HashMap.
            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                CardView card = (CardView) ((LinearLayout) recyclerView.getChildAt(i)).getChildAt(0);
                RelativeLayout layout = (RelativeLayout) card.getChildAt(0);
                CheckBox check = (CheckBox) layout.getChildAt(2);
                TextView topping = (TextView) layout.getChildAt(0);
                toppings.put(topping.getText().toString(), check.isChecked());
            }

            // Create a new instance of the menu item (type Food)
            Food food = (Food) Class.forName("com.ood.restaurant.Data." + itemName).newInstance();

            // Loop through decorator that were placed in the hashmap above.
            for (Map.Entry<String, Boolean> entry : toppings.entrySet()) {
                String topping = entry.getKey();
                Boolean add = entry.getValue();

                // If checkbox is selected
                if (add) {
                    // Decorate the menu item
                    food = (Food) Class.forName("com.ood.restaurant.Data." + topping)
                            .getConstructor(Food.class).newInstance(new Food[]{food});

                    //Class<?> food2 = Class.forName("com.ood.restaurant.Data." + topping);
                    //Constructor<?> ctor = food2.getConstructor(Food.class);
                    //Food object = (Food)ctor.newInstance(new Food[]{food2});
                }
            }

            // Get the description
            String foodDescription = food.getDescription();

            // Close the dialog and show a toast
            MenuFragment.customizeOrderFragment.dismiss();

            // Display a message with the food description and the cost.
            Toast.makeText(getContext(), foodDescription + "\nCost: $" + food.cost(), Toast.LENGTH_SHORT).show();

            // Create an order object and add it to the database.
            Order order = new Order();
            order.setOrderDescription(food.getDescription());
            order.setCost(food.cost());
            myDB.insertOrder(order, AddOrderCommand.table);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException |
                NoSuchMethodException | java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }
}
