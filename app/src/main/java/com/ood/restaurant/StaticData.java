package com.ood.restaurant;

import com.ood.restaurant.Data.Bacon;
import com.ood.restaurant.Data.BaconBits;
import com.ood.restaurant.Data.Burger;
import com.ood.restaurant.Data.Cheese;
import com.ood.restaurant.Data.Decorator;
import com.ood.restaurant.Data.Food;
import com.ood.restaurant.Data.Lettuce;
import com.ood.restaurant.Data.Menu;
import com.ood.restaurant.Data.Mushrooms;
import com.ood.restaurant.Data.Olives;
import com.ood.restaurant.Data.Onions;
import com.ood.restaurant.Data.Pepperoni;
import com.ood.restaurant.Data.Pizza;
import com.ood.restaurant.Data.Sausage;
import com.ood.restaurant.Data.Tomatoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Singleton pattern
 */
public class StaticData {

    private static StaticData instance = null;
    private ArrayList<Boolean> tableList = new ArrayList<>();
    private List<Class> Menu = new ArrayList<>();
    private HashMap<>
    public HashMap<Class, List<Decorator>> ItemsToDecorators = new HashMap<>();

    /**
     * Private constructor
     */
    private StaticData() {
        for (int i = 0; i < 15; i++) {
            tableList.add(true);
        }
        populateMenu();
        addStuff();
    }

//    public void addMenuItem(Food item)
//    {
//        Menu.add(item);
//    }

    /**
     * Get the singleton instance
     * @return Singleton instance
     */
    public static synchronized StaticData i() {
        if (instance == null) {
            instance = new StaticData();
        }
        return instance;
    }

    /**
     * Get the table list
     * @return Table list
     */
    public ArrayList<Boolean> tables() {
        return this.tableList;
    }

    public List<Class> getMenu()
    {
        return this.Menu;
    }

    private void addStuff()
    {
        // LOL SUCH BAD CODE!
        // Condiments for a Burger.
        List<Decorator> burgerDecorators = new ArrayList<>();
        burgerDecorators.add(new Tomatoes());
        burgerDecorators.add(new Lettuce());
//        burgerDecorators.add(new Onions());
//        burgerDecorators.add(new Cheese());
//        burgerDecorators.add(new Bacon());as
        ItemsToDecorators.put(Burger.class, burgerDecorators);

        // Condiments for a Pizza
        List<Decorator> pizzaDecorators = new ArrayList<>();
         pizzaDecorators.add(new Pepperoni());
//        pizzaDecorators.add(new Olives());
//        pizzaDecorators.add(new Sausage());
//        pizzaDecorators.add(new Mushrooms());
//        pizzaDecorators.add(new BaconBits());


        ItemsToDecorators.put(Pizza.class,pizzaDecorators);
    }

    private void populateMenu()
    {
        this.Menu.add(Burger.class);
        this.Menu.add(Pizza.class);
    }


    public HashMap<Class,List<Decorator>> getStuff()
    {

        return ItemsToDecorators;
    }



}

