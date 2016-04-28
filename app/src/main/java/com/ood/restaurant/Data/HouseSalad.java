package com.ood.restaurant.Data;

/**
 *
 * @author Nicholas Lilly
 */
public class HouseSalad extends Food
{
    private double cost;
    public HouseSalad()
    {
        FoodName = "HouseSalad";
    }
    @Override
    public double cost()
    {
        cost = 4.99;

        return cost;
    }
}
