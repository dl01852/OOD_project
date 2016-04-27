package com.ood.restaurant;

import com.ood.restaurant.Data.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Singleton pattern to store table states
 * @author Michael Palmer
 */
public class StaticData {

    private static StaticData instance = null;
    private ArrayList<Boolean> tableList = new ArrayList<>();
    private List<Class> Menu = new ArrayList<>();
    public HashMap<Class, List<Decorator>> ItemsToDecorators = new HashMap<>();

    /**
     * Private constructor - initialize 15 available tables
     */
    private StaticData() {
        for (int i = 0; i < 15; i++) {
            tableList.add(true);
        }
        populateMenu();
        addStuff();
    }

    /**
     * Get the singleton instance, creating a new instance if needed
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
        // Condiments for a Burger.
        List<Decorator> burgerDecorators = new ArrayList<>();
        burgerDecorators.add(new Tomatoes());
        burgerDecorators.add(new Lettuce());
        burgerDecorators.add(new Onions());
        burgerDecorators.add(new Cheese());
        burgerDecorators.add(new Bacon());
        ItemsToDecorators.put(Burger.class, burgerDecorators);

        // Condiments for a Pizza
        List<Decorator> pizzaDecorators = new ArrayList<>();
        pizzaDecorators.add(new Pepperoni());
        pizzaDecorators.add(new Olives());
        pizzaDecorators.add(new Sausage());
        pizzaDecorators.add(new Mushrooms());
        pizzaDecorators.add(new BaconBits());
        ItemsToDecorators.put(Pizza.class,pizzaDecorators);

        //Condiments for fried chicken
        List<Decorator> friedChickenDecorators = new ArrayList<>();
        friedChickenDecorators.add(new MacnCheese());
        friedChickenDecorators.add(new FriedOkra());
        friedChickenDecorators.add(new CollardGreens());
        ItemsToDecorators.put(FriedChicken.class,friedChickenDecorators);

        // Condiments for bbq ribs
        List<Decorator> bbqRibsDecorator = new ArrayList<>();
        bbqRibsDecorator.add(new Coleslaw());
        bbqRibsDecorator.add(new TexasToast());
        bbqRibsDecorator.add(new BBQSauce());
        ItemsToDecorators.put(BBQRibs.class,bbqRibsDecorator);

        // Condiments for house salad
        List<Decorator> houseSaladDecorator = new ArrayList<>();
        houseSaladDecorator.add(new RanchDressing());
        houseSaladDecorator.add(new CaesarDressing());
        houseSaladDecorator.add(new VinaigretteDressing());
        houseSaladDecorator.add(new ItalianDressing());
        ItemsToDecorators.put(HouseSalad.class,houseSaladDecorator);

        // Condiments for house salad
        List<Decorator> caesarSaladDecorator = new ArrayList<>();
        caesarSaladDecorator.add(new RanchDressing());
        caesarSaladDecorator.add(new CaesarDressing());
        caesarSaladDecorator.add(new VinaigretteDressing());
        caesarSaladDecorator.add(new ItalianDressing());
        ItemsToDecorators.put(CaesarSalad.class,caesarSaladDecorator);
    }

    private void populateMenu()
    {
        this.Menu.add(Burger.class);
        this.Menu.add(Pizza.class);
        this.Menu.add(CaesarSalad.class);
        this.Menu.add(HouseSalad.class);
        this.Menu.add(BBQRibs.class);
        this.Menu.add(FriedChicken.class);
    }


    public HashMap<Class,List<Decorator>> getStuff()
    {

        return ItemsToDecorators;
    }



}

