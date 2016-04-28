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
import com.ood.restaurant.orderDatabase;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Fragment for customizing orders
 */
public class CustomizeOrderFragment extends DialogFragment implements View.OnClickListener {
    private RecyclerView recyclerView;
    String itemName;
    StaticData sData = StaticData.i();
    orderDatabase myDB = MainActivity.myDB;

    /**
     * Create the view
     * @param inflater Layout inflater
     * @param container View group
     * @param savedInstanceState Bundle
     * @return View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Set the dialog title
        super.getDialog().setTitle(getArguments().getString("title")); // same as FoodName.
        // Get the item name from the arguments passed in
        itemName = getArguments().getString("itemName"); // Food Name
        // Inflate the layout
        View layout = inflater.inflate(R.layout.fragment_customizeorder_list, container, false);
        // Create recycler view
        recyclerView = (RecyclerView) layout.findViewById(R.id.customize_list);
        // Create the adapter and assign it to the recycler view
        CustomizeItemViewAdapter decoratorAdapter = new CustomizeItemViewAdapter(getActivity(),
                converToMenuItem(itemName));
        recyclerView.setAdapter(decoratorAdapter);
        // Set on click listener for the "Order" button
        Button button = (Button) layout.findViewById(R.id.btn_save_order);
        button.setOnClickListener(this);
        return layout;
    }

    /**
     * Create the fragment
     * @param savedInstanceState Bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setMenuVisibility(true);
    }

    /**
     * Grabs all Decorators for a particular Food item and and converts
     * them to MenuItemData objects to display in the GUI
     * @param itemName Item name
     * @return List of MenuItemData elements
     */
    public List<MenuItemData> converToMenuItem(String itemName) {
        List<MenuItemData> data = new ArrayList<>();
        // Need to use the full path to the class
        String className = "com.ood.restaurant.Data." + itemName.trim();
        try {
            // Create class reference
            List<Decorator> getClass = sData.getStuff().get(Class.forName(className));

            for (Decorator d : getClass) {
                MenuItemData tempData = new MenuItemData();
                // Invoke the item's getName() method
                tempData.itemName = (String) d.getClass()
                        .getMethod("getName", (Class[]) null)
                        .invoke(d, (Object[]) null);
                // Invoke the item's getDecoratorDescription() method
                tempData.itemDescription = (String) d.getClass()
                        .getMethod("getDecoratorDescription", (Class[]) null)
                        .invoke(d, (Object[]) null);
                // Invoke the item's getCost() method
                tempData.itemPrice = (Double) d.getClass()
                        .getMethod("getCost", (Class[]) null)
                        .invoke(d, (Object[]) null);
                // Add item to the list
                data.add(tempData);
            }

        } catch (Exception e) {
            // Exception...
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Handle on click events
     * @param v View that triggered the event
     */
    @Override
    public void onClick(View v) {
        try {
            Map<String, Boolean> toppings = new HashMap<>();

            // places all the decorators Name and whether or not if it is checked or not into a HashMap.
            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                // Initialize the layouts
                CardView card = (CardView) ((LinearLayout) recyclerView.getChildAt(i)).getChildAt(0);
                RelativeLayout layout = (RelativeLayout) card.getChildAt(0);
                // Get the "Add" checkbox
                CheckBox check = (CheckBox) layout.getChildAt(2);
                // Get the topping name
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
                    // Decorate the menu item. This creates a new instance of the specified class,
                    // passing the existing food class as a parameter to the constructor.
                    food = (Food) Class.forName("com.ood.restaurant.Data." + topping)
                            .getConstructor(Food.class).newInstance(new Food[]{food});
                }
            }

            // Get the description
            String foodDescription = food.getDescription();

            // Close the dialog
            MenuFragment.customizeOrderFragment.dismiss();

            // Display a message with the food description and the cost.
            Toast.makeText(getContext(), foodDescription +
                    "\nCost: $" + food.cost(), Toast.LENGTH_SHORT).show();

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
