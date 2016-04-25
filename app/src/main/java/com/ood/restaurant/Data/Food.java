package com.ood.restaurant.Data;

/**
 * Created by david-lewis on 3/28/2016.
 * Decorator Pattern for "decorating" any food item(if it needs to be decorated)..
 */
public abstract class Food
{
   protected String FoodName = "Generic Food ";

    public String getDescription()
    {
        return FoodName;
    }

    public abstract double cost();

    public abstract String orderMessage();
}
