package com.ood.restaurant.Data;

/**
 * Created by Nicholas on 4/26/2016.
 */
public class HouseSalad extends Food
{
    private double cost;
    public HouseSalad()
    {
        FoodName = "House Salad";
    }
    @Override
    public double cost()
    {
        cost = 4.99;

        return cost;
    }
}
