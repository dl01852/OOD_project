package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class FriedChicken extends Food
{
    private double cost;

    public FriedChicken()
    {
        FoodName = "FriedChicken";
    }
    @Override
    public double cost()
    {
        cost = 10.99;
        return cost;
    }

    @Override
    public String orderMessage() {
        return "Fried Chicken Added...";
    }
}
