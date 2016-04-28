package com.ood.restaurant.Data;

/**
 *
 * @author Nicholas Lilly
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
}
