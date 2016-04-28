package com.ood.restaurant.Data;

/**
 *
 * @author Nicholas Lilly
 */
public class Pizza extends Food
{
    private double cost;

    public Pizza()
    {
        FoodName = "Pizza";
    }

    @Override
    public String getDescription()
    {
        return super.getDescription();
    }

    @Override
    public double cost()
    {
        cost = 10.99;
        return cost;
    }
}
