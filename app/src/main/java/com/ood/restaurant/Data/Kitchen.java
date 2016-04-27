package com.ood.restaurant.Data;

import com.ood.restaurant.StaticData;

import java.util.List;
import java.util.Map;

/**
 * Created by jlarkin9 on 4/25/16.
 */
public class Kitchen {
//    Food bacon;
//    Food baconBits;
//    Food burger;
//    Food cheese;
//    Food lettuce;
//    Food mushrooms;
//    Food olives;
//    Food onions;
//    Food pepperoni;
//    Food pizza;
//    Food sausage;
//    Food tomatoes;

    public Kitchen() {
        try {
            for (Map.Entry<Class, List<Decorator>> item : StaticData.i().ItemsToDecorators.entrySet()) {
                item.getKey().newInstance();
                for (Decorator decorator : item.getValue()) {
                    decorator.getClass().newInstance();
                }
            }
//            burger = new Burger();
//            pizza = new Pizza();
//            bacon = new Bacon(food);
//            baconBits = new BaconBits(food);
//            cheese = new Cheese(food);
//            lettuce = new Lettuce(food);
//            mushrooms = new Mushrooms(food);
//            olives = new Olives(food);
//            onions = new Onions(food);
//            pepperoni = new Pepperoni(pizza);
//            sausage = new Sausage(pizza);
//            tomatoes = new Tomatoes(burger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOrderMessage(Food food) {
        return food.orderMessage();
    }

}
