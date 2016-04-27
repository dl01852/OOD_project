package com.ood.restaurant.Data;

/**
 * Created by jlarkin9 on 4/25/16.
 */
public class Kitchen {
    Food bacon;
    Food baconBits;
    Food burger;
    Food cheese;
    Food lettuce;
    Food mushrooms;
    Food olives;
    Food onions;
    Food pepperoni;
    Food pizza;
    Food sausage;
    Food tomatoes;

    public Kitchen() {

        burger = new Burger();
        pizza = new Pizza();
        bacon = new Bacon(burger);
        baconBits = new BaconBits(pizza);
        cheese = new Cheese(burger);
        lettuce = new Lettuce(burger);
        mushrooms = new Mushrooms(pizza);
        olives = new Olives(pizza);
        onions = new Onions(burger);
        pepperoni = new Pepperoni(pizza);
        sausage = new Sausage(pizza);
        tomatoes = new Tomatoes(burger);
    }

    public String getOrderMessage(Food food) {
        return food.orderMessage();
    }

}
