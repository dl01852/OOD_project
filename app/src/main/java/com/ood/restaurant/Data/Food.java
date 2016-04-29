package com.ood.restaurant.Data;

/**
 * The parent class for all the menu items
 * @author Nicholas Lilly
 */
public abstract class Food
{
   protected String FoodName = "Generic Food";

    public String getDescription()
    {
        return FoodName;
    }

    public abstract double cost();
}
